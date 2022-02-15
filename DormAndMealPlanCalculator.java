/* Program: DormAndMealPlanCalculator
   Date: May 7, 2018
   Author: Jonathan Price
   
   This program is designed to get a dorm and meal
   plan selection from the user through the use of
   two separate combo boxes, then display the
   combined cost in a read-only text box. When run, 
   this program will display a window with two combo
   boxes and a read-only text box. One of the combo
   boxes will hold the dorms while the other will
   hold the meal plans. The read-only text box will
   display the combined cost of the two. After being 
   executed, this program needs the user to select
   a dorm from one of the combo boxes and a meal plan
   from the other.
   
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DormAndMealPlanCalculator extends JFrame
{
   private JLabel label1, label2, label3, label4, label5;   //Displays a message
   private JPanel dormPanel;  //Hold dorm panel components
   private JComboBox dormBox; //List of dorms
   private JTextField selectedDorm; //Selected dorm
   private JPanel mealPanel;  //Hold meal plan panel components
   private JComboBox mealBox; //List of meal plans
   private JTextField selectedMeal; //Selected meal plan
   private JPanel totalPanel; //Hold the total panel component
   private JTextField total;  //Total cost
   
   //Create an array to hold the values to be in dormBox
   private String[] dorms = {"Allen Hall: $" + 1500, "Pike Hall: $" + 1600,
                             "Farthing Hall: $" + 1200, "University Suites: $" + 1800};
                             
   //Create an array to hold the costs of the dorms
   double[] dorm_cost = {1500, 1600, 1200, 1800};
   
   //Create an array to hold the values to be in mealBox
   private String[] meals = {"7 meals per week: $" + 560, "14 meals per week: $" + 1095,
                             "Unlimited meals per week: $" + 1500};
                             
   //Create an array to hold the costs of the meal plans
   double[] meal_cost = {560, 1095, 1500};
   
   /**
      Constructor
   */
   
   public DormAndMealPlanCalculator()
   {
      //Set the title
      setTitle("Dorm & Meal Plan Calculator");
      
      //Specify and action for the close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Create a BorderLayout manager
      setLayout (new GridLayout(3, 2));
      
      //Build the panels
      buildDormPanel();
      buildMealPanel();
      buildTotalPanel();
      
      //Add the panels to the content pane
      add(dormPanel);
      add(mealPanel);
      add(totalPanel);
      
      //Pack and display the window
      pack();
      setVisible(true);
   }
   
   /**
      The buildDormPanel method adds a combo box with the
      types of dorms to a panel
   */
   
   private void buildDormPanel()
   {
      //Create the panel with a label
      dormPanel = new JPanel();
      label1 = new JLabel("Select a dorm: ");
      
      //Create the combo box
      dormBox = new JComboBox(dorms);
      
      //Register an action listener, dormBox, and label to panel
      dormBox.addActionListener(new ComboBoxListener());
      dormPanel.add(label1);
      dormPanel.add(dormBox);
   }
   
   /**
      The buildMealPanel method adds a combo box
      with the types of meal plans to the panel
   */
   
   private void buildMealPanel()
   {
      //Create the panel with a label
      mealPanel = new JPanel();
      label2 = new JLabel("Select a meal plan: ");
      
      //Create the combo box
      mealBox = new JComboBox(meals);
      
      //Register an action listener, add label  and mealBox to panel
      mealBox.addActionListener(new ComboBoxListener());
      mealPanel.add(label2);
      mealPanel.add(mealBox);
   }
      
   /**
      buildTotalPanel function adds a read-only text
      box to the panel.
   */
   
   private void buildTotalPanel()
   {
      //Create the panel with a label
      totalPanel = new JPanel();
      label5 = new JLabel("Your total charge for this semester is: ");
      
      //Create the read-only text box
      total = new JTextField(10);
      total.setEditable(false);
      
      //Add the label and text box to the panel
      totalPanel.add(label5);
      totalPanel.add(total);
   }
   
   /**
      Private inner class that handels the events when
      the user selects an item from the combo box
   */
   
   private class ComboBoxListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //Declare variables
         int d;   //Dorm
         int m;   //Meal plan
         double t;  //String total
         
         //Get the selected dorm
         dormBox.getSelectedItem();
         d = dormBox.getSelectedIndex();
         
         //Get the selected meal plan
         mealBox.getSelectedItem();
         m = mealBox.getSelectedIndex();
         
         //Add the selections
         t = dorm_cost[d] + meal_cost[m];
         total.setText("$" + t);
         
      }
   }
   
   /**
      The main method creates an instance of the class
   */
   
   public static void main(String[] args)
   {
      new DormAndMealPlanCalculator();
   }
}