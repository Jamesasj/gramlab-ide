package fr.gramlab;

import java.awt.EventQueue;
import java.awt.Frame;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.OceanTheme;

import fr.gramlab.config.GramlabConfigManager;
import fr.gramlab.frames.GramlabFrame;
import fr.umlv.unitex.exceptions.UnitexUncaughtExceptionHandler;

public class Main {
	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				launchGramlab(args);
			}
		});
	}

	private static JFrame frame;
	
	protected static void launchGramlab(@SuppressWarnings("unused") String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(
				UnitexUncaughtExceptionHandler.getHandler());
		Locale.setDefault(Locale.ENGLISH);
		try {
			javax.swing.plaf.metal.MetalLookAndFeel
					.setCurrentTheme(new OceanTheme());
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			System.err
					.println("Ocean Theme not supported on this platform. \nProgram Terminated");
			System.exit(0);
		} catch (IllegalAccessException e) {
			System.err
					.println("Ocean Theme could not be accessed. \nProgram Terminated");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.err
					.println("Your version of Java does not contain all the classes required by GramLab.\nProgram Terminated");
			System.exit(0);
		} catch (InstantiationException e) {
			System.err
					.println("Ocean Theme can not be instantiated. \nProgram Terminated");
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Unexpected error. \nProgram Terminated");
			e.printStackTrace();
			System.exit(0);
		}
		GramlabConfigManager.initConfig();
        frame = new GramlabFrame();
        frame.setVisible(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	public static JFrame getMainFrame() {
		return frame;
	}
	
}