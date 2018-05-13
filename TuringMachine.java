/*159331 - Assignment 2 Semester 1
 * Junyi Chen - 16192554
 */

import java.util.ArrayList;
public class TuringMachine {
	
	/*Tape of the machine*/
	private ArrayList<String> machineTape;
	
	/*a finite set states of the turing machine*/
	private ArrayList<String> machineState;
	
	/*a finite set of alphabet with at least two symbols*/
	private ArrayList<String> machineAlphabet;
	
	/*Input alphabet*/
	private ArrayList<String> machineInputAlphabet;
	
	/*initial state*/
	private String initialState;
	
	/*final State*/
	private String finalState;
	
	/*head of the tape*/
	private int head;
	
	/*insturction table*/
	private ArrayList<Instruction> instructionTable;
	
	/*Constructor*/
	public TuringMachine(ArrayList<String> State, ArrayList<String> Alphabet,  ArrayList<String> Input, 
			String initialS, String finalS, ArrayList<Instruction> table){	
		
			machineTape = new ArrayList<String>();
			machineState = State;
			machineAlphabet = Alphabet;
			machineInputAlphabet = Input;
			instructionTable = table;
			initialState = initialS;
			finalState = finalS;
			head = 0;
			/*initialise tape with input alphabet*/
			for(String s : machineInputAlphabet){
				machineTape.add(s);
			}
	}
	
	/* write to tape at position head */
	public void writeToTape(String alph){
		machineTape.set(head, alph);
	}
	
	/*read the alphabet that head is currently pointing at*/
	public String readFromTape(){
		return machineTape.get(head);
	}
	
	/*move tape once to the right*/
	public void moveRight(){
		head++;
	}
	
	/*move tape once to the left*/
	public void moveLeft(){
		head--;
	}
	
	/*Simulate the algorithm*/
	public void simulate(){
		/*Printing all the details*/
		printState();
		printSymbol();
		printInput();
		printInitialState();
		printFinalState();
		printInstructions();
		
		
	}
	
	/*Print the states*/
	public void printState(){
		System.out.print("States (Q) : ");
		for(String str : machineState){
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
	/*Print the symbols*/
	public void printSymbol(){
		System.out.print("Symbols (S) : ");
		for(String str : machineAlphabet){
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
	/*Print the input*/
	public void printInput(){
		System.out.print("Input Word (I) : ");
		for(String str : machineInputAlphabet){
			System.out.print(str + " ");			
		}
		System.out.println();
	}
	
	/*Print the inital state*/
	public void printInitialState(){
		System.out.print("Initial State (q0) : ");
		System.out.println(initialState);
	}
	
	/*Print the final state*/
	public void printFinalState(){
		System.out.print("Final State (F) : ");
		System.out.println(finalState);
	}
	
	/*Print insturctions*/
	public void printInstructions(){
		System.out.println("Instruction Table (delta) : ");
		for(Instruction ins : instructionTable){
			ins.printInsturction();
		}
	}
		
}

