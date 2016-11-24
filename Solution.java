package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      
      
      PriorityQueue<Student> pq = new PriorityQueue<>(10, new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			if(o1.getCgpa()<o2.getCgpa()){
				//System.out.println("1 : 1");
				return 1;
			}
			else if (o1.getCgpa()>o2.getCgpa()){
				//System.out.println("2 : -1");
				
				return -1;
			}
			else{
				int temp = o1.getFname().compareTo(o2.getFname());
				if(temp==0){
					//System.out.println("3 : 0");
					return o1.getToken()-o2.getToken();
					
				}else{
					//System.out.println("4 : "+temp);
					return temp;
				}
			}
			
		}
	});
      
      
      int token;
      String name;
      double cgpa;
      while(totalEvents>0){
         String event = in.next();
            
           //Complete your code
         if(event.equals("ENTER")){
        	 name = in.next();
        	 cgpa = in.nextDouble();
        	 token = in.nextInt();
        	 Student s = new Student(token, name, cgpa);
        	 pq.add(s);
         }else{
        	 pq.poll();
        	 //pq.r
         }
           
         totalEvents--;
      }
      
      //System.out.println(pq.toString());
     // for(Student s : pq){
    	//  System.out.println(s.getFname()+" "+s.getCgpa()+" "+s.getToken());
     // }
      
      while(!pq.isEmpty()){
    	  Student s = pq.poll();
    	  System.out.println(s.getFname()+" "+s.getCgpa()+" "+s.getToken());
      }
      
    }
}

