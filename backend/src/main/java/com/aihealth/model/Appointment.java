package com.aihealth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "appointments")
public class Appointment {

    @Id
    private String id;

    private String patientId;
    private String doctorName;
    private String specialty;
    private LocalDateTime appointmentDateTime;
    private String reason;
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    private String notes;
    private String meetingLink;

    @CreatedDate
    private LocalDateTime createdAt;
}
