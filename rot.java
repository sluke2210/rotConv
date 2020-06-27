import java.util.ArrayList;

public class rot{
		public static int firstArg;
		public static String secondArg;
		public static String thrdArg;
		public static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};



public static String encodeRot(int shift, String data){
        char[] dataCharArr = data.toLowerCase().toCharArray();
        ArrayList<Integer> dataIntArrLst = new ArrayList<Integer>();
        ArrayList<Integer> encodedDataIntArrLst = new ArrayList<Integer>();
        String rotEncodedData = "";

        if(shift < 0 || shift > 25){
            System.out.println("shift out of range");
        }

	//convert the char's to ints e.g a = 1, b = 2 etc
        for (char c : dataCharArr) {
            for (int i = 0; i < alphabet.length; i++) {
                if(c == alphabet[i]){
                    dataIntArrLst.add(i);
                }
            }
        }
//compute the shift by adding the shift value to each element of the data int array list. 0 or (a) + shift (1) = encoded int. 
//shift = 0 A - > A ; shift = 1 A -> B (0 + 1) . The mod 26 means any number > 26 wraps around back to 0
        for (Integer integer : dataIntArrLst) {
            encodedDataIntArrLst.add((integer + shift)%26);
        }
//constructs the new encoded string 
        for (Integer integer : encodedDataIntArrLst) {
            for (int i = 0; i < alphabet.length; i++) {
                if(integer == i){
                    rotEncodedData = rotEncodedData + alphabet[i];
                }
            }
        }

        return rotEncodedData;
    }



     public static String decodeRot(int shift, String data){
        char[] encodedDataCharArr = data.toLowerCase().toCharArray();
        ArrayList<Integer> encodedDataIntArrLst = new ArrayList<Integer>();
        ArrayList<Integer> dataIntArrLst = new ArrayList<Integer>();
        String resData ="";

        for (char c : encodedDataCharArr) {
            for (int i = 0; i < alphabet.length; i++) {
                if(c == alphabet[i]){
                    encodedDataIntArrLst.add(i);
                }
            }
        }
	     //Here we decode the encoded Int Array by subtracting the shift instead. We check for negative values and subtract there magnitute from 26 to find the correct char
        for (Integer integer : encodedDataIntArrLst) {
		
            if((integer - shift)<0){
                dataIntArrLst.add((26 + (integer - shift)));
            }else {
                dataIntArrLst.add((integer - shift) % 26);
            }
        }

        for (Integer integer : dataIntArrLst) {
            for (int i = 0; i < alphabet.length; i++) {
                if(integer == i){
                    resData = resData + alphabet[i];
                }
            }
        }

        return resData.toString();

    }


	public static void main(String[] args){

		if(args.length != 3){
			System.out.println("Useage: rot shift , encode/decode (en / de) , data");
			System.out.println("Example: rot 2 en hello");
			System.out.println("Example: rot 2 de goodbye");

		}else if(args.length == 3) {

  	 	 try {
       		 firstArg = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
        System.err.println("Argument" + args[0] + " must be an integer.");
        System.exit(1);
    }
     secondArg = args[1];
     thrdArg = args[2];
}

if(secondArg.equals("en")){

	System.out.println(encodeRot(firstArg, thrdArg));
}else if(secondArg.equals("de")){
	System.out.println(decodeRot(firstArg, thrdArg));
}

	
}


}


