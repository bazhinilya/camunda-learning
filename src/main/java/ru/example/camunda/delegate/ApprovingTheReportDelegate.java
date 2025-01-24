package ru.example.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ApprovingTheReportDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String department = execution.getVariable("department").toString();
        execution.setVariable("ApprovedBy" + department, true);
    }
}