package com.hims.appointment.application.usecase;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.application.exception.BaseException;
import com.hims.appointment.application.exception.exception_enums.ExceptionEnums;
import com.hims.appointment.application.interfaces.IAppointmentRepository;
import com.hims.appointment.application.mapper.DtoMapper;
import com.hims.appointment.application.usecases.AppointmentUseCase;
import com.hims.appointment.domain.entity.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentUseCaseTest {

    @Mock
    private IAppointmentRepository appointmentRepository;

    @Mock
    private DtoMapper appointmentMapper;

    @InjectMocks
    private AppointmentUseCase appointmentUseCase;

    private UUID testId;
    private Appointment testAppointment;
    private AppointmentDto testAppointmentDto;

    @BeforeEach
    void setUp() {

        testId = UUID.randomUUID();

        testAppointment = new Appointment();
        testAppointment.setId(testId);
        testAppointment.setPatientId(UUID.randomUUID());
        testAppointment.setDoctorId(UUID.randomUUID());
        testAppointment.setDateTime(LocalDateTime.now().plusDays(1));

        testAppointmentDto = new AppointmentDto();
        testAppointmentDto.setId(testId);
        testAppointmentDto.setPatientId(testAppointment.getPatientId());
        testAppointmentDto.setDoctorId(testAppointment.getDoctorId());
        testAppointmentDto.setDateTime(testAppointment.getDateTime());


    }

    @Test
    void findById_WhenAppointmentExists_ReturnsAppointmentDto() {
        // Test implementation goes here

        when(appointmentRepository.findById(testId))
                .thenReturn(Optional.of(testAppointment));

        when(appointmentMapper.toDto(testAppointment))
                .thenReturn(testAppointmentDto);

        AppointmentDto result = appointmentUseCase.findById(testId);

        assertNotNull(result);
        assertEquals(testId, result.getId());

        verify(appointmentRepository, times(1)).findById(testId);
        verify(appointmentMapper, times(1)).toDto(testAppointment);
    }

    @Test
    void findById_WhenAppointmentDoesNotExist_ShouldThrowAppointmentNotFoundException() {

        when(appointmentRepository.findById(testId))
                .thenReturn(Optional.empty());

        BaseException exception = assertThrows(BaseException.class, () -> {
            appointmentUseCase.findById(testId);
        });

        assertEquals(ExceptionEnums.APPOINTMENT_NOT_FOUND, exception.getErrorMessage().getMessageType());

        verify(appointmentMapper, never()).toDto(any(Appointment.class));
    }

    @Test
    void save_WhenDataIsValid_ShouldCallRepositorySave() {

        when(appointmentMapper.toEntity(testAppointmentDto))
                .thenReturn(testAppointment);


        appointmentUseCase.save(testAppointmentDto);


        verify(appointmentRepository, times(1)).save(testAppointment);
    }

    @Test
    void save_WhenDateIsInThePast_ShouldThrowInvalidAppointmentDateException() {

        LocalDateTime pastDate = LocalDateTime.now().minusDays(1);
        testAppointmentDto.setDateTime(pastDate);
        testAppointment.setDateTime(pastDate);


        when(appointmentMapper.toEntity(testAppointmentDto))
                .thenReturn(testAppointment);

        BaseException exception = assertThrows(BaseException.class, () -> {
            appointmentUseCase.save(testAppointmentDto);
        });

        assertEquals(ExceptionEnums.INVALID_APPOINTMENT_DATE, exception.getErrorMessage().getMessageType());

        verify(appointmentRepository, never()).save(any(Appointment.class));
    }

    @Test
    void findAll_WhenListIsEmpty_ShouldReturnEmptyDtoList() {

        when(appointmentRepository.findAll()).thenReturn(List.of());


        when(appointmentMapper.toDtoList(anyList())).thenReturn(List.of());


        List<AppointmentDto> result = appointmentUseCase.findAll();


        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


}
