package undo;

import java.util.Stack;

/**
 * StringBuilder c возможность откада изменений строки.
 */
public class StringBuilderWithUndo {

    /**
     * StringBuilder который хранит текущую строку.
     */
    private StringBuilder stringBuilder;

    /**
     * Stack, который хранит историю изменений строки.
     */
    private Stack<State> history;

    /**
     * Внутренняя запись для хранения состояния строки.
     *
     * @param state строковое представление состояния
     */
    private record State(String state) {}

    /**
     * Создает новый объект undo.StringBuilderWithUndo, содержащий указанную строку.
     * Инициализирует историю изменений с начальным состоянием.
     *
     * @param string начальная строка
     */
    public StringBuilderWithUndo(String string) {
        stringBuilder = new StringBuilder(string);
        history = new Stack<>();
        saveState();
    }

    /**
     * Отменяет последнюю операцию, изменяющую состояние и восстанавливает предыдущее состояние из истории.
     *
     * @return true если отмена выполнена успешно, false если нет операций для отмены
     */
    public Boolean undo() {
        if (history.size() > 1) {
            history.pop();
            State tempState = history.peek();
            stringBuilder.setLength(0);
            stringBuilder.append(tempState.state);
            return true;
        } else return false;
    }

    /**
     * Сохраняет текущее состояние в истории изменений.
     * Вызывается автоматически перед каждой операцией, изменяющей состояние.
     */
    private void saveState() {
        State tempState = new State(stringBuilder.toString());
        history.push(tempState);
    }

    /**
     * Добавляет указанную строку в конец текущей строки.
     * Перед выполнением операции сохраняет текущее состояние.
     *
     * @param string строка для добавления
     */
    public void append(String string) {
        saveState();
        stringBuilder.append(string);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
