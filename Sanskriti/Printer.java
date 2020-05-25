public class Printer {

	boolean coloured; // to tell printer to print in black/white or coloured
	int num_copies; // num of copies of the document required
	String size_paper; // size of paper like A4, letter etc.
	int print_id; // a unique id associated with the Printer object
	boolean completed; // to tell if the print job is complete or not
	
	// constructors
	public Printer() {
	}

	public Printer(boolean c, int num, String sizePaper, int id) {
	}

	// function called when print command is given
	// returns true if print command successfully completed, else returns false
	boolean print() {
		return true;
	}

	// function to cancel print command
	// takes current queued print objects, finds the object with the given id, and
	// removes it from queue
	void cancel_print(Printer P[], int id) {

	}

	// function to display print ids of all print objects in the queue along with
	// their completion status
	void show_print_ids(Printer P[]) {
	}
	
	public static void main(String args[]) {
		System.out.println("Hello World");
	}
}
