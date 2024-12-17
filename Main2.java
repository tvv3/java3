package mypackage;
import java.util.Scanner;

public class Main2 {
	
	//start at 00.11

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner myObj = new Scanner(System.in);
		
	final int a=myObj.nextInt();//nr de chocolate disponibile
	final int b=myObj.nextInt();//suma lui Choco in total
		int zmax2=-3, zmax=-1;//zmax2 va fi cate bucati cumpara Choco cu o suma maxima <= b
		int imax2=-5;
		String s=myObj.next();//insiruirea de chocolate bucati disponibile
		int[] pret = new int[26];
		for (int i=0; i<26; i++)
		   {
			pret[i]=myObj.nextInt();
		   }
		
		String alfab="abcdefghijklmnopqrstuvwxyz";//26 litere posibile
		int[] preturialfabselectie=new int[26];
		
		int[] preturi2=new int[s.length()];//the real prices for the pieces in the string
		for (int i=0; i<s.length(); i++)
		{
		   for (int j=0; j<26; j++)
		   {
			   if (s.charAt(i)==alfab.charAt(j))
			   {
				 preturi2[i]=pret[j];
				 break;//iese doar din al 2-lea for
			   }
			}
		}
	
		int[] sume=new int[s.length()];
		int sumacurenta2=0, maximcurent2=0,sumacurenta=0,maximcurent=0;
		for(int i=0; i<s.length();i++)
		//int i=0; //mereu pornesc de la prima choco 
		{
	     
			sumacurenta=0;
		  	maximcurent=0;
		  	zmax=-2;
		 for (int poz=i;poz<s.length();poz++)
	     
		 {
		  	
		  	for (int j=0; j<26; j++)
			   {
	  			preturialfabselectie[j]=0;//initializare
			   }
		  	
		  	for(int z=i; z<=poz; z++)
		  	
		  	{
		  		
		  	  char c=s.charAt(z);
		  	  int p=preturi2[z];
		  	 for (int j=0; j<26; j++)
			   {
				   if (c==alfab.charAt(j))
				   {
					 preturialfabselectie[j]+=p;
					 break;//iese doar din al 2-lea for cu j
				   }
				}
		  	}//end z
		  	 //calcul maxim pretalfabselectie
		  	 
		  	 int max=0;
		  	 for (int j=0; j<26; j++)
			   {
	  			if (max <preturialfabselectie[j])
	  			{
	  				max=preturialfabselectie[j];
	  			}
	  				//end calcul maxim
			   }
		  	 
		  	for (int j=0; j<26; j++)
			   {
	  			if (max ==preturialfabselectie[j])
	  			{
	  				preturialfabselectie[j]=0; break;
	  			}
	  				//aleg un tip de choco cu pretul maxim si ii fac pretul 0
			   }

		  	int sumac=0;
		  	for (int j=0; j<26; j++)
			   {
	  			sumac+=
	  				preturialfabselectie[j];
	  			}
	  				//calcul sumaselectiecurenta
			   
		  	if (sumac>b) {sumac=0;}
		  	
		  	sumacurenta=sumac;
		  	
		  	if ((zmax<poz)&&(sumacurenta!=0)) //aici trebuie <= ca sa ia ultimele pozitii pt maxim ex avem 4 3 4 sa ia poz 2 al doilea 4 !!!
		  		{maximcurent=sumacurenta;
		  	     zmax=poz;
		  	     sumacurenta=0; 
		  		}
		  	
		  	}//end for poz
		  	
		   sumacurenta2=maximcurent;
		   //if (maximcurent2<sumacurenta2)
		   if ((zmax2-imax2+1<zmax-i+1)&&(sumacurenta2<=b))
		   {
			   maximcurent2=sumacurenta2;
			   sumacurenta2=0;
			   zmax2=zmax;
			   imax2=i;
		   }
	     
		 //System.out.println(zmax+1);//de la pozitia 0 pana la poz zmax sunt zmax+1 pozitii
		}//end for i //i=0
		System.out.println("From position: "+imax2);//de la pozitia imax2
		System.out.println("To position: "+zmax2);//la pozitia zmax2
			
		System.out.println("Total number of pieces of chocolates: "+(zmax2+1-imax2));//nr bucati chocolati - rezultatul cerut de problema !!!!
		
		/*
		 *
 6 10
dabbcb
11 14 4 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
		*/

	}

}

/*PRoblem :

Problem Statement :

Choco, a chocolate lover, has N amount of money with him. He wants to buy as much
 chocolate as possible. So, he goes to a chocolate shop “Bandyman ”. 
 Mike, the owner of “Bandyman ” has different types of chocolate in his store
  (represented by a character) placed in a row.

Mike, give an offer to Choco that he can buy a selected type of chocolate for free 
and need to pay for the other types of chocolates and Choco can only buy consecutive 
chocolates.

Now, you need to write a code to find the maximum amount of chocolates Choco can get
 by selecting the chocolates optimally.

Input format :

1st line contains 2 space separated integers A and B denoting the number
 of chocolates and the amount of money Choco has.

The 2nd line contains A chocolates represented by a string.
 All chocolates represented by lowercase alphabets.

The 3rd line represents 26 space separated integers representing the cost to buy the
 chocolates.
[First integer represents the cost of the chocolate of type ‘a’, 
    2nd integer represents the cost of the chocolates of type ‘b’ and so on]

Output format :
Print the maximum number of chocolates Choco can buy.

Constraints :
1<=A<=10^5
1<=B<=10^9
1<=cost of chocolate<=10^9

Sample input 1 :
6 10
aabcda
5 4 4 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

Sample output 1 :
4

Explanation :

Choco can select the chocolate of type ‘a’ for free and start buying from index 0 and if he buys “aabc” then he has to pay less (0+0+4+4=8) than the total money he has.

This is the maximum number of chocolates he can get in this case.

*/


