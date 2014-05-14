package org.vaadin.training.data;

import lombok.Delegate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EmployeeProxy {

    @Delegate(types = InterestedIn.class)
    private final Person person;

    private interface InterestedIn {
        String getFirstName();
        void setFirstName(String name);
        String getLastName();
        void setLastName(String name);
        String getEmail();
        void setEmail(String email);
        double getSalary();
        void setSalary(double salary);
        int getId();
        void setId(int id);
    }
}
