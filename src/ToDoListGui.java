import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ToDoListGui extends JFrame implements ActionListener {
  // taskPanel will act as the container for the taskComponentsPanel
  // taskComponentPanel will store all of the taskComponents
  private JPanel taskPanel, taskComponentPanel;

  public ToDoListGui() {
    super("To Do List Application");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(CommonConstants.GUI_SIZE);
    pack();
    setLocationRelativeTo(null);
    setResizable(false);
    setLayout(null);

    addGuiComponent();
  }

  private void addGuiComponent() {
    // Banner Text
    JLabel bannerLabel = new JLabel("To Do List");
    bannerLabel.setFont(createFont("resources/LEMONMILK-Light.otf", 32f));
    bannerLabel.setBounds((CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width) / 2, 15,
        CommonConstants.BANNER_SIZE.width,
        CommonConstants.BANNER_SIZE.height);

    // taskPanel
    taskPanel = new JPanel();

    // taskComponentPanel
    taskComponentPanel = new JPanel();
    taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
    taskPanel.add(taskComponentPanel);

    // add scrolling to the task panel
    JScrollPane scrollPane = new JScrollPane(taskPanel);
    scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
    scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
    scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // changing the speed of the scroll bar
    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    verticalScrollBar.setUnitIncrement(20);

    // add task button
    JButton addTaskButton = new JButton("Add Task");
    addTaskButton.setFont(createFont("resources/LEMONMILK-Light.otf", 18f));
    addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height - 88, CommonConstants.ADDTASK_BUTTON_SIZE.width,
        CommonConstants.ADDTASK_BUTTON_SIZE.height);
    addTaskButton.addActionListener(this);

    // add to frame
    this.getContentPane().add(bannerLabel);
    this.getContentPane().add(scrollPane);
    this.getContentPane().add(addTaskButton);
  }

  private Font createFont(String resource, float size) {
    try {
      // get the font file path using getResourceAsStream instead
      java.io.InputStream fontStream = getClass().getClassLoader().getResourceAsStream(resource);
      if (fontStream != null) {
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(size);
        fontStream.close();
        return customFont;
      }
    } catch (Exception e) {
      System.out.println("Error loading font: " + e.getMessage());
    }

    // fallback to default font if custom font fails
    return new Font("Arial", Font.PLAIN, (int) size);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if (command.equalsIgnoreCase("Add Task")) {
      // create a task component
      TaskComponent taskComponent = new TaskComponent(taskComponentPanel);

      // add the task component to the panel
      taskComponentPanel.add(taskComponent);

      // make the previous task appear disabled
      if (taskComponentPanel.getComponentCount() > 1) {
        TaskComponent previousTask = (TaskComponent) taskComponentPanel
            .getComponent(taskComponentPanel.getComponentCount() - 2);
        previousTask.getTaskField().setBackground(null);
      }

      // make the task field request focus after creation
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          taskComponent.getTaskField().requestFocus();
        }
      });

      // refresh the display
      taskComponentPanel.revalidate();
      taskComponentPanel.repaint();
    }
  }
}
