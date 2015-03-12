package classSchedule;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * The user interface for the schedule
 * Prints the schedule and courses underneath the major
 */



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class viewSchedule extends JFrame{
	//private major majorFirst;
	private modelSchedule model;
	private controllerSchedule controller;


	public viewSchedule()
	{

	}
	//Set the model
	public void setModel(modelSchedule model) {
		this.model = model;
	}

	// Set the controller
	public void setController(controllerSchedule controller) {
		this.controller = controller;
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		//user input for the major
		System.out.println("Please enter a major: ");
		String result = keyboard.nextLine();

				// Create model and controller objects
				modelSchedule model = new modelSchedule();
				controllerSchedule controller = new controllerSchedule();

				// Use the controller to initialize the model
				controller.initModel(model);

				// Create the view, and connect it to the model and controller objects
				viewSchedule view = new viewSchedule();
				view.setModel(model);
				view.setController(controller);
				
				//asks the user for a major and determines if it is a minor and prints them out
				List<Major> listOfMajors = new ArrayList<Major>();
				boolean isMinor;
				Major majorAddition;
				String result2;
				String response;

				do
				{
					System.out.println("Please enter a major: ");
					result2 = keyboard.nextLine();

					System.out.println("Is this a minor?");
					response = keyboard.nextLine();

					if(response.equalsIgnoreCase("yes"))
					{
						isMinor = true;
					}
					else
					{
						isMinor = false;
					}

					majorAddition = new Major(result2, isMinor, null);
					listOfMajors.add(majorAddition);

					System.out.println("Do you want to add another major?");
					response = keyboard.nextLine();
				}while(response.equalsIgnoreCase("YES"));

				System.out.println("Here is a list of all majors");
				int numberofmajors = listOfMajors.size();

				Major currentMajor;
				System.out.println("Major Name \t is a Minor");
				for(int i = 0; i < numberofmajors; i++)
				{
					currentMajor = listOfMajors.get(i);
					System.out.print(currentMajor.getName());
					System.out.print("\t\t");
					if(currentMajor.determineMinor())
						System.out.print("Yes\n");
					else
						System.out.print("No\n");

				}
				
				for(Course test: model.getSched())
				{
					System.out.println(test);
				}
				/*
		// Register mouse event handlers
				 * this will be used for the search button when they type
				 * in their major, minor, or course
		MouseAdapter listener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				handleMousePressed(e);
			}
<<<<<<< HEAD
		*/
		
		keyboard.close();
		
		}
		
=======

				 */

>>>>>>> refs/remotes/Kyle/master
	}
}
