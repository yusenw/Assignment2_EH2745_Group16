package assignment2;

import java.util.ArrayList;

public class KNN {
	
	private ArrayList<Dis_Time> K1;
	static int knn=40;
	private ArrayList<Dis_Time> K2;
	private ArrayList<Dis_Time> K3;
	public KNN(ArrayList<Dis_Time> M1) {
		K1 = M1;
		K2 = K1;
		
	        //模拟需要返回的前k个最大数字
		K3= qSAndBS(K2);
	    }
		
//		for (int i = 0; i < knn; i++) {
//	         int index = i;
//	         for (int j = i; j < K2.size(); j++) {
//				if(K2.get(index).GetKNN_dis()>K2.get(j).GetKNN_dis()){
//	        		 index = j;
//	        	 }
//	        	 Dis_Time temp = K2.get(index);//
//	        	 K2.set(index, K2.get(i));
//	        	 K2.set(i, temp);
//	         } 
//	     }
	
	public ArrayList<Dis_Time> Getdislabel() {
//		for(int i=0;i<K1.size();i++) {
//			System.out.println("***********************************************************");
//			System.out.println("the"+ i +" distance is"+K1.get(i).GetKNN_dis());
//			System.out.println("the"+ i +" time is"+K1.get(i).Gettime()+"\n");
//		}
			return K1;
		}
	
	public  ArrayList<Dis_Time> Sort(){
//		for(int i=0;i<K3.size();i++) {
//			System.out.println("##############################################################");
//			System.out.println("the"+ i +" distance is"+K3.get(i).GetKNN_dis());
//			System.out.println("the"+ i +" time is"+K3.get(i).Gettime()+"\n");
//		}
//		
		return K3;
	}
	
	 private static ArrayList<Dis_Time> qSAndBS(ArrayList<Dis_Time> K2) {
		 ArrayList<Dis_Time> Ksort = quickSort(K2, 0, K2.size() - 1);
	        ArrayList<Dis_Time> res = new ArrayList<Dis_Time>();
	        for (int i = 0; i < knn; i++) {
	        	res.add(Ksort.get(i));
	        }
	        return res;
	    }

	 private static ArrayList<Dis_Time> quickSort(ArrayList<Dis_Time> K2, int start, int end) {
	        if (start >= end) return K2;
	        int index = start, i = start, j = end + 1;
	        while (true) {
	        	 while (K2.get(++i).GetKNN_dis() <= K2.get(index).GetKNN_dis()) if (i == end) break;
		         while (K2.get(--j).GetKNN_dis() >= K2.get(index).GetKNN_dis()) if (j == index) break;
	            if (j <= i) break;
	            Dis_Time temp = K2.get(i);
	            K2.set(i, K2.get(j));
	            K2.set(j, temp);
	        }
	        Dis_Time temp = K2.get(j);
	        K2.set(j, K2.get(index));
	        K2.set(index, temp);
	        index = j;
	        quickSort(K2, start, index - 1);
	        quickSort(K2, index + 1, end);
	        return K2;
	    }
	
	
	
	
		
//	public static double[] GetMini() {
//		ArrayList<Dis_Time> dis_total1 = chooseSort(dis_total);
//		ArrayList<Dis_Time> res = new ArrayList<Dis_Time>();
////        double[] res = new double[k];
//        for (int i = 0; i < knn; i++) {
//            res[i] = value1[i];
//        }
//        return res;
//    }

// private static double[] chooseSort(double[] value, int k) {
//        for (int i = 0; i < k; i++) {
//            int index = i;
//            for (int j = i; j < value.length; j++)
//                if (value[index] > value[j]) index = j;
//            double temp = value[index];
//            value[index] = value[i];
//            value[i] = temp;
//        } 
//        double[] value1 = value;
//        return value1;
//    }
 
// public static ArrayList<Dis_Time> chooseSort() {
//	
//     for (int i = 0; i < knn; i++) {
//         int index = i;
//         for (int j = i; j < K1.size(); j++) {
//			if(K1.get(index).GetKNN_dis()>K1.get(j).GetKNN_dis()){
//        		 index = j;
//        	 }
//        	 Dis_Time temp = K1.get(index);//
//        	 K1.set(index, K1.get(i));
//        	 K1.set(i, temp);
//         } 
//     }
////     ArrayList<Dis_Time> dis_total1 = dis_total;
//     return K1;
// }
} 

