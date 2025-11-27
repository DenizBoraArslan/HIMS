package com.hims.appointment.presentation.config;

public final class ApiPaths {

    private ApiPaths() {

    }

    public static final String API_BASE = "/api/v1/appointments";

    public static final String SAVE_APPOINTMENT = "/save";
    public static final String GET_ALL_APPOINTMENTS = "/all";
    public static final String GET_BY_DOCTOR_ID = "/doctor";
    public static final String GET_BY_PATIENT_ID = "/patient";
    public static final String DELETE_APPOINTMENT = "/delete";
    public static final String UPDATE_APPOINTMENT = "/update";
}
