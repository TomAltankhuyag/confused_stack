import java.io.*;
import java.util.*;
public class Main{
    public static void main(String args[]) throws FileNotFoundException, IOException{
        if (!(args[0].substring(args[0].length() - 4).equals(".txt"))){//Make sure the command line inputs have proper name for both arg[0]
            args[0] += ".txt";                                         //and arg[0] (input & output respectively)
        }
        if (!(args[1].substring(args[1].length() - 4).equals(".txt"))){
            args[1] += ".txt";
        }
      
        PrintWriter writer = new PrintWriter(args[1], "UTF-8"); //Output file
        List test = new List();
        boolean inputStatus = true;
        
		try {
			
			File myFile = new File(args[0]); //Input File 
			Scanner myFileReader = new Scanner(myFile); // Input File reader


			while(myFileReader.hasNextLine()) {
               
				String text = myFileReader.nextLine();


                if(text.equals("") && myFileReader.hasNextLine()){
                   
                    writer.print("Input error.");
                    inputStatus = false;
                    break;

                }else if(test.isInteger(text) == false && test.checkSymbol(text) == false){
                    writer.print("Input error.");
                    inputStatus = false;
                    break;
                }
                
                test.add(text);
               
			}
			myFileReader.close();
         

		} catch (FileNotFoundException e) {
			System.out.println("Input Exception Error.");
			e.printStackTrace();
		}
        
        if(inputStatus){ //Writes result into outputfile when all the input are valid
            test.sort();
            if(test.check666){
                for(int i = 1; i < test.length(); i++){
                    if(!test.getData(i).equals("666")){
                        writer.println(test.getData(i));
                    }
                    
                }
                if(!test.getData(test.length()).equals("666")){
                    writer.print(test.getData(test.length()));
                }
                
            }else{
                for(int i = 1; i < test.length(); i++){
                    writer.println(test.getData(i));
                }
                if(!test.getData(test.length()).equals("666")){
                    writer.print(test.getData(test.length()));
                }
            }

         }
       


	
      
		writer.close();
        

        


    }
}

  