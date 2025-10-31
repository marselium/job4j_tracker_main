package ru.job4j.tracker;

import ru.job4j.tracker.Output;

public class ValidateInput implements Input {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные");
            }
        } while (invalid);
        return value;
    }

    private boolean isNumber(String value) {
        boolean result = true;
        char[] check = value.toCharArray();
        for (char number : check) {
            if (number < 48 || number > 57) {
                result = false;
                break;
            }
        }
        return result;
    }
}