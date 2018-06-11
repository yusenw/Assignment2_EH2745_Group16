package assignment2;

import java.util.ArrayList;

public class KNN_sort {
	ArrayList<Dis_Time> arr = new ArrayList<Dis_Time>();
	int knn;
	static ArrayList<Dis_Time> res = new ArrayList<Dis_Time>();
	public KNN_sort(ArrayList<Dis_Time> K2,int k) {
		arr = K2;
		knn = k;
		res = qSAndBS(arr, k);
	}

	public static ArrayList<Dis_Time> Getsort(){
		return res;
	}
	 private static ArrayList<Dis_Time> qSAndBS(ArrayList<Dis_Time> arr,int knn) {
		 	quickSort(arr, 0, arr.size() - 1);
	        ArrayList<Dis_Time> res = new ArrayList<Dis_Time>();
	        for (int i = 0; i < knn; i++) {
	        	res.add(arr.get(i));
	        }
	        return res;
	    }

	 private static void quickSort(ArrayList<Dis_Time> K2, int start, int end) {
	        if (start >= end) return;
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
	    }
	
}
