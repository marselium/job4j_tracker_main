package ru.job4j.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.SqlTracker;

public interface UserAction {
    String name();

    boolean execute(Input input, SqlTracker sqlTracker);
}
