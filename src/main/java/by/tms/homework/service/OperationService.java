package by.tms.homework.service;

import by.tms.homework.model.Operation;
import by.tms.homework.storage.InMemoryOperationStorage;

public class OperationService {
    private final InMemoryOperationStorage operationStorage = new InMemoryOperationStorage();

    public Operation calculate(Operation operation) {
        switch (operation.getOperation()) {
            case "+":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "-":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "*":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "/":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.save(operation);
                return operation;
        }
        throw new IllegalArgumentException();
    }
}
