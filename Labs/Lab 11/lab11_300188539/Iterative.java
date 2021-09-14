public class Iterative {

	public static BitList complement( BitList in ) {

		Iterator it = in.iterator(); 
        String tmp = ""; 

        while (it.hasNext()) { 
            int current = it.next(); 

            if (current == BitList.ONE) { 
                tmp += BitList.ZERO; 
            } else { 
                tmp += BitList.ONE; 
            }
        }

        return new BitList(new StringBuilder(tmp).reverse().toString()); 
	}

	public static BitList or( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iter_A = a.iterator(); 
        Iterator iter_B = b.iterator(); 
        String tmp = "";

        while(iter_A.hasNext()) { 
            int curr_A = iter_A.next(); 
            int curr_B = iter_B.next(); 


            if (curr_A == BitList.ZERO && curr_B == BitList.ZERO) { 
                tmp += BitList.ZERO; 
            } else { 
                tmp += BitList.ONE; 
            }
        }

        return new BitList(new StringBuilder(tmp).reverse().toString());
        
	}

	public static BitList and( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iter_A = a.iterator(); 
        Iterator iter_B = b.iterator(); 
        String tmp = "";

        while(iter_A.hasNext()) { 
            int curr_A = iter_A.next(); 
            int curr_B = iter_B.next(); 

            if(curr_A == BitList.ONE && curr_B == BitList.ONE) { 
                tmp += BitList.ONE; 
            } else { 
                tmp += BitList.ZERO; 
            }
        }

        return new BitList(new StringBuilder(tmp).reverse().toString()); 
	}

	public static BitList xor( BitList a, BitList b ) {

        if (a.toString().length() != b.toString().length()) { 
            throw new IllegalArgumentException(); 
        }

        if (a.toString().equals(String.valueOf(BitList.ZERO)) || b.toString().equals(String.valueOf(BitList.ZERO))) { 
            throw new IllegalArgumentException(); 
        }

        Iterator iter_A = a.iterator(); 
        Iterator iter_B = b.iterator(); 
        String tmp = "";

        while(iter_A.hasNext()) { 
            int curr_A = iter_A.next(); 
            int curr_B = iter_B.next();

            if (curr_A == BitList.ONE && curr_B == BitList.ONE) { 
                tmp += BitList.ZERO; 
            } else if (curr_A == BitList.ZERO && curr_B == BitList.ZERO) { 
                tmp += BitList.ZERO; 
            } else { 
                tmp += BitList.ONE; 
            }
        }

        return new BitList(new StringBuilder(tmp).reverse().toString());
	
	}
}