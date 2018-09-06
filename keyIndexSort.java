package Strings;
/**
 * 键索引排序法
 * 用于小整数键的排序,小于实数R，整数级别
 * @author Administrator
 *
 */
public class keyIndexSort {
		public void sort(Student[] a,int R){
			int N = a.length;
			Student[] aux = new Student[N];
			int[] count = new int[R+1];//计算频率
			
			//计算出现的概率
			for(int i=0;i<N;i++){
				count[a[i].key+1]++;
			}
			//将频率转换为索引
			//因为频率代表了出现的数量，相当于用频率排了序
			for(int r=0;r>R;r++){
				count[r+1] += count[r];
			}
			//最关键一步
			//将元素分类
			//之前的count[]数组都是从下标2开始出现数字，即0与1中都是0，现在从1开始，即又将频率从前一位开始排序，正好对应顺序
			for(int i=0;i<N;i++){
				aux[count[a[i].key()]++] = a[i];
			}
			//回写
			for(int i=0;i<N;i++){
				a[i] = aux[i];
			}
		}
		class Student{
			private String name;
			private int key;
			public Student(String name, int key) {
				super();
				this.name = name;
				this.key = key;
			}
			public int key(){
				return key;
			}
			@Override
			public String toString() {
				return "Student [name=" + name + ", key=" + key + "]";
			}
			
		}
}
