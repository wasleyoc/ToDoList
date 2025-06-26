import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TaskComponent extends JPanel implements ActionListener {
  private JCheckBox checkBox;
  private JTextPane taskField;
  private JButton deleButton;

  public JTextPane getTaskField() {
    return taskField;
  }

  // this panel is used so that we can make updates to the task component panel
  // when deleting tasks
  private JPanel parentPanel;

  public TaskComponent(JPanel parentPanel) {
    this.parentPanel = parentPanel;

    // task field
    taskField = new JTextPane();
    taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
    taskField.setContentType("text/html");

    // checkbox
    checkBox = new JCheckBox();
    checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
    checkBox.addActionListener(this);

    // delete button
    deleButton = new JButton("x");
    deleButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
    deleButton.addActionListener(this);

    // add to this taskComponent
    add(checkBox);
    add(taskField);

    add(deleButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == checkBox) {
      if (checkBox.isSelected()) {
        // replaces all html tags to empty string (fixed regex)
        String taskText = taskField.getText().replaceAll("<[^>]*>", "");

        // add strikethrough text
        taskField.setText("<html><s>" + taskText + "</s></html>");
      } else if (!checkBox.isSelected()) {
        // replaces all html tags to empty string (fixed regex)
        String taskText = taskField.getText().replaceAll("<[^>]*>", "");
        taskField.setText(taskText);
      }
    } else if (e.getSource() == deleButton) {
      // remove this task component from parent panel
      parentPanel.remove(this);
      parentPanel.revalidate();
      parentPanel.repaint();
    }

    if (e.getActionCommand().equalsIgnoreCase("x")) {
      // delete this component from the parent panel
      parentPanel.remove(this);
      parentPanel.repaint();
      parentPanel.revalidate();

    }
  }

}
