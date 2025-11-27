package com.hims.appointment.application.usecases;

import com.hims.appointment.application.dto.AppointmentDto;
import com.hims.appointment.application.exception.BaseException;
import com.hims.appointment.application.exception.ErrorMessage;
import com.hims.appointment.application.exception.exception_enums.ExceptionEnums;
import com.hims.appointment.application.interfaces.IAppointmentRepository;
import com.hims.appointment.application.mapper.DtoMapper;
import com.hims.appointment.domain.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentUseCase {

    private final IAppointmentRepository appointmentRepository;
    private final DtoMapper dtoMapper;

    //Save Appointment
    public void save(AppointmentDto appointmentDto) {

        Appointment appointment = dtoMapper.toEntity(appointmentDto);

        if (appointment.getDateTime().isBefore(LocalDateTime.now())) {

            throw new BaseException(new ErrorMessage(ExceptionEnums.INVALID_APPOINTMENT_DATE));
        }
        if (appointment.getDoctorId() == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.DOCTOR_ID_CANNOT_BE_NULL));
        }
        if (appointment.getPatientId() == null) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.PATIENT_ID_CANNOT_BE_NULL));


        }
        appointmentRepository.save(appointment);

    }

    //Find Appointment by id
    public AppointmentDto findById(UUID id) {

        Appointment foundAppointment = appointmentRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(ExceptionEnums.APPOINTMENT_NOT_FOUND)));

        return dtoMapper.toDto(foundAppointment);

    }

    //Find All Appointments
    public List<AppointmentDto> findAll() {

        List<Appointment> appointmentList = appointmentRepository.findAll();

        return dtoMapper.toDtoList(appointmentList);
    }

    //Delete Appointment by id
    public void deleteById(UUID id) {

        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(ExceptionEnums.APPOINTMENT_NOT_FOUND)));

        appointmentRepository.deleteById(id);
    }

    //Find Appointments by Doctor id
    public List<AppointmentDto> findByDoctorId(UUID doctorId) {

        List<Appointment> appointmentList = appointmentRepository.findByDoctorId(doctorId);

        return dtoMapper.toDtoList(appointmentList);
    }

    //Find Appointments by Patient id
    public List<AppointmentDto> findByPatientId(UUID patientId) {

        List<Appointment> appointmentList = appointmentRepository.findByPatientId(patientId);

        return dtoMapper.toDtoList(appointmentList);
    }

    //Update Appointment
    public void updateAppointment(AppointmentDto appointmentDto) {

        Appointment existingAppointment = appointmentRepository.findById(appointmentDto.getId()).orElseThrow(() -> new BaseException(new ErrorMessage(ExceptionEnums.APPOINTMENT_NOT_FOUND)));

        Appointment appointment = dtoMapper.toEntity(appointmentDto);

        if (appointment.getDateTime().isBefore(LocalDateTime.now())) {

            throw new BaseException(new ErrorMessage(ExceptionEnums.INVALID_APPOINTMENT_DATE));
        }
        if(!appointmentDto.getId().equals(existingAppointment.getId())) {
            throw new BaseException(new ErrorMessage(ExceptionEnums.ID_CANNOT_BE_CHANGED));
        }

        existingAppointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
        existingAppointment.setDateTime(appointmentDto.getDateTime());
        existingAppointment.setDoctorId(appointmentDto.getDoctorId());
        existingAppointment.setPatientId(appointmentDto.getPatientId());
        appointmentRepository.save(existingAppointment);

    }

}
