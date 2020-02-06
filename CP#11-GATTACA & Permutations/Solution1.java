import java.util.*;
class Solution1 {

	public static class SuffixArray
	{
		int[] SA;
		char[] s;
		
		public SuffixArray(char[] s)
		{
			this.s = s;
			int n = s.length, RA[] = new int[n];
			SA = new int[n];
			for(int i = 0; i < n; ++i) { 
				SA[i] = i; RA[i] = s[i]; 
			}
			
			for(int k = 1; k < n; k <<= 1) {
				sort(SA, RA, n, k);
				sort(SA, RA, n, 0);
				
				int[] tmp = new int[n];
				for(int i = 1, r = 0, s1 = SA[0], s2; i < n; ++i) {
					s2 = SA[i];
					tmp[s2] = RA[s1] == RA[s2] && RA[s1 + k] == RA[s2 + k] ? r : ++r;
					s1 = s2;
				}
				
				for(int i = 0; i < n; ++i)
					RA[i] = tmp[i];
				
				if(RA[SA[n-1]] == n - 1)
					break;
			}
		}
		
		void sort(int[] SA, int[] RA, int n, int k) {
			int maxi = Math.max(256, n), c[] = new int[maxi];
			for(int i = 0; i < n; ++i)
				c[i + k < n ? RA[i + k] : 0]++;
			for(int i = 0, sum = 0; i < maxi; ++i) {
				int t = c[i];
				c[i] = sum;
				sum += t;
			}
			int[] tmp = new int[n];
			for(int i = 0; i < n; ++i) {
				int j = SA[i] + k;
				tmp[c[j < n ? RA[j] : 0]++] = SA[i];
			}
			
			for(int i = 0; i < n; ++i)
				SA[i] = tmp[i];
		}
		
		String LCP() {
			int n = s.length;
			int maxL = 0, idx = -1, LCP[] = new int[n], phi[] = new int[n], PLCP[] = new int[n];
			phi[SA[0]] = -1;
			for(int i = 1; i < n; ++i)
				phi[SA[i]] = SA[i-1];
			
			for(int i = 0, L = 0; i < n; ++i) {
				if(phi[i] == -1)
					continue;
				int j = phi[i];
				while(s[i + L] == s[j + L])
					++L;
				maxL = Math.max(maxL, L);
				PLCP[i] = L;
				if(L != 0)
					--L;
			}
			for(int i = 0; i < n; ++i) {
				LCP[i] = PLCP[SA[i]];
				if(idx == -1 && LCP[i] == maxL)
					idx = i;
			}

			if(maxL == 0)
				return "No repetitions found!";
			else {
				String ret = new String(Arrays.copyOfRange(s, SA[idx], SA[idx++] + maxL)); 
				int occ = 2;
				while(idx < n && LCP[idx] == LCP[idx-1]) {
					++occ;
					++idx;
				}
				return ret + " " + occ;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-- > 0)
		{
			String s = sc.next() + "$";
			SuffixArray sa = new SuffixArray(s.toCharArray());
			System.out.println(sa.LCP());
		}
	}
}