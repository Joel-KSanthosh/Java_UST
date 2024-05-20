package module3.c1.linkedlist;
// Operation enum to represent different types of operations
enum OperationType {
    INSERTION,
    DELETION
}
// Operation class to represent an operation in the text editor
class Operation {
    private OperationType type;
    private String content;
    public Operation(OperationType type, String content) {
        this.type = type;
        this.content = content;
    }
    public OperationType getType() {
        return type;
    }
    public String getContent() {
        return content;
    }
}
// TextEditor class to manage undo and redo functionality
class TextEditor {
    private Operation currentOperation;
    private TextEditorNode undoStackTop;
    private TextEditorNode redoStackTop;
    public TextEditor() {
        currentOperation = null;
        undoStackTop = null;
        redoStackTop = null;
    }
    // Method to perform an operation (insertion or deletion)
    public void performOperation(Operation operation) {
        currentOperation = operation;
        addToUndoStack(operation);
    }
    // Method to add an operation to the undo stack
    private void addToUndoStack(Operation operation) {
        TextEditorNode newNode = new TextEditorNode(operation);
        newNode.setNext(undoStackTop);
        undoStackTop = newNode;
    }
    // Method to undo the last operation
    public void undo() {
        if (undoStackTop != null) {
            Operation undoneOperation = undoStackTop.getOperation();
            undoStackTop = undoStackTop.getNext();
            addToRedoStack(undoneOperation);
            System.out.println("Undo: " + undoneOperation.getType() + " '" + undoneOperation.getContent() + "'");
        } else {
            System.out.println("Nothing to undo.");
        }
    }
    // Method to add an operation to the redo stack
    private void addToRedoStack(Operation operation) {
        TextEditorNode newNode = new TextEditorNode(operation);
        newNode.setNext(redoStackTop);
        redoStackTop = newNode;
    }
    // Method to redo the last undone operation
    public void redo() {
        if (redoStackTop != null) {
            Operation redoneOperation = redoStackTop.getOperation();
            redoStackTop = redoStackTop.getNext();
            addToUndoStack(redoneOperation);
            System.out.println("Redo: " + redoneOperation.getType() + " '" + redoneOperation.getContent() + "'");
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}
// TextEditorNode class to represent a node in the undo/redo stack
class TextEditorNode {
    private Operation operation;
    private TextEditorNode next;
    public TextEditorNode(Operation operation) {
        this.operation = operation;
        this.next = null;
    }
    public Operation getOperation() {
        return operation;
    }
    public TextEditorNode getNext() {
        return next;
    }
    public void setNext(TextEditorNode next) {
        this.next = next;
    }
}
public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        // Perform some operations
        textEditor.performOperation(new Operation(OperationType.INSERTION, "Hello"));
        textEditor.performOperation(new Operation(OperationType.INSERTION, "World"));
        textEditor.performOperation(new Operation(OperationType.DELETION, "d"));
        // Undo operations
        textEditor.undo(); // Undo deletion: "d"
        textEditor.undo(); // Undo insertion: "World"
        // Redo operations
        textEditor.redo(); // Redo insertion: "World"
        textEditor.redo(); // Redo deletion: "d"
        textEditor.redo(); // Nothing to redo
    }
}

