package ru.wherebackend.vtbmoretech.entity.event;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import ru.wherebackend.vtbmoretech.entity.employee.Employee;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "VTBMT_PARTICIPANT")
@Entity(name = "vtbmt_Participant")
public class Participant {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    @Column(name = "APPROVED")
    private Boolean approved;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @InstanceName
    @DependsOnProperties({"employee", "event", "approved"})
    public String getInstanceName() {
        return String.format("%s - %s: %s", employee, event, approved);
    }
}