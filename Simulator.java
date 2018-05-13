/*159331 - Assignment 2 Semester 1
 * Junyi Chen - 16192554
 */
import java.io.*;
import java.util.*;

public class Simulator {

	
	public static void main(String[] args) {
		
		ArrayList<String> machineState = new ArrayList<String>();/*a finite set states of the turing machine*/
		ArrayList<String> machineAlphabet = new ArrayList<String>();/*a finite set of alphabet with at least two symbols*/
		ArrayList<String> machineInputAlphabet = new ArrayList<String>();	/*Input alphabet*/	
		String initialState = "";/*initial state*/
		String finalState =  "";/*final State*/
		ArrayList<Instruction> instructionTable = new ArrayList<Instruction>();
		
		/*Getting input */
		Scanner sc = new Scanner(System.in);
		while(true){
			/*get file name from user*/
			String fileName = "";
			System.out.println("Please enter file name : ");
			if(sc.hasNextLine()){
				fileName = sc.nextLine();
			}
			File file = new File(fileName);
			
			/*If file exists, read the file*/
			if(file.exists()){
				try{
					FileReader fRead = new FileReader(file);
					BufferedReader reader = new BufferedReader(fRead);
					String str;
					int index = 1;
					/*Read thorugh the file*/
					while((str = reader.readLine())!= null){
				
						if(str.startsWith("#")){
							/*Comment line, igonore*/
							continue;
						} 
						else {
							/*Not comment line, check the index number*/
							String[] tempStr;
							
							if(index == 1){/*Reading all the possible states of the machine*/
								/*split the sentence by space*/
								tempStr = str.split(" ");
								/*add to array list*/
								machineState.clear();
								for(String s : tempStr){
									machineState.add(s);
								}
							}
							else if(index == 2){/*Reading alphabet */
								tempStr = str.split(" ");
								/*add to array list*/
								machineAlphabet.clear();
								for(String s : tempStr){
									machineAlphabet.add(s);
								}
							}
							else if(index == 3){/*Reading Input alphabet*/
								tempStr = str.split(" ");
								machineInputAlphabet.clear();
								for(String s : tempStr){
									/*Check if s is subset of alphabet set*/
									if(machineAlphabet.contains(s)){
										machineInputAlphabet.add(s);
									} else {
										System.out.println("Alphabet " + s + " not in alphabet set");
										throw new Exception();
									}
								}
							}
							else if(index == 4){/*Reading the initial State*/
								initialState = str;
							} 
							else if(index == 5){/*Reading the final state*/
								finalState = str;
							}
							/*Reading instructions*/
							else {
								tempStr = str.split(" ");
								Instruction ins = new Instruction(tempStr[0], tempStr[1], tempStr[2], tempStr[3], Integer.parseInt(tempStr[4]) );
								instructionTable.add(ins);
							}
							index++;
						}
						/*End while*/
					}
					/*Finish reading*/
					reader.close();
					break;
				} catch (Exception e){
					continue;
				}
			} 
			else {
				/*file doesnt exits, prompt user enter file name again*/
				System.out.println("File " + fileName + " doesn't exist.");
				continue;
			}
			/*End while*/
		}
		/*Instantiate a new Turing Machine*/
		TuringMachine myMachine = new TuringMachine(machineState, machineAlphabet, machineInputAlphabet, initialState, finalState, instructionTable);
		
		myMachine.simulate();
		
		
		
		/*Debugging
		System.out.println("States are : ");
		for(String s : machineState){
			System.out.println(s);
		}
		
		
		System.out.println("Alphabets are : ");
		for(String s : machineAlphabet){
			System.out.println(s);
		}
		
		System.out.println("Input Alphabets are : ");
		for(String s : machineInputAlphabet){
			System.out.println(s);
		}
		
		System.out.println("Initial State is : ");
		System.out.println(initialState);
		
		System.out.println("Final State is : ");
		System.out.println(finalState);
		
		System.out.println("Insturctions are : ");
		for(Instruction i : instructionTable){
			i.printInsturction();
		}*/
		
		
	}
	
}
