package view;

import controller.TaskController;
import database.entities.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TaskView extends JFrame {
    private final TaskController taskController;

    private JPanel panel;
    private JTable taskTable;
    private JTextField textField;
    private JButton buttonAdd;
    private JButton buttonUpdate;
    private JButton buttonRemove;
    private JScrollPane scrollPane;
    private JLabel title;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;

        this.setContentPane(this.panel);
        this.setTitle("Gerenciador de Tarefas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        this.setupTable();
        this.setupListeners();
        this.refreshTable();
    }

    private void setupTable() {
        this.taskTable.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"ID", "Título", "Concluída"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void setupListeners() {
        this.buttonAdd.addActionListener(e -> {
            String title = this.textField.getText().trim();

            if (!title.isEmpty()) {
                this.taskController.createTask(new Task(title, false));
                this.textField.setText("");
                this.refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Digite um título válido");
            }
        });

        this.buttonRemove.addActionListener(e -> {
            int selectedRow = this.taskTable.getSelectedRow();

            if (selectedRow != -1) {
                int taskId = (int) this.taskTable.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja realmente excluir a tarefa?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_NO_OPTION) {
                    this.taskController.deleteTask(taskId);
                    this.refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover.");
            }
        });

        this.buttonUpdate.addActionListener(e -> {
            int selectedRow = this.taskTable.getSelectedRow();

            if (selectedRow != -1) {
                int taskId = (int) this.taskTable.getValueAt(selectedRow, 0);
                boolean currentStatus = (boolean) taskTable.getValueAt(selectedRow, 2);
                this.taskController.updateTask(taskId, !currentStatus);
                this.refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa para atualizar.");
            }
        });
    }

    private void refreshTable() {
        ArrayList<Task> tasks = this.taskController.listAll();
        DefaultTableModel model = (DefaultTableModel) taskTable.getModel();
        model.setRowCount(0);

        for (Task task : tasks) {
            model.addRow(new Object[]{task.getId(), task.getTitle(), task.getFinished()});
        }
    }
}
