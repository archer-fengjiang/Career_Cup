package leetcode;

public class FB {
	// The strncmp() function compares the first (at most)
	// n characters of the null-terminated strings s1 and s2.

	// It returns an integer less than, equal to, or greater
	// than zero if s1 is found, respectively, to be less than,
	// to match, or be greater than s2.

	// Example: strncmp("A", "a", 1) < 0        ASCII order
	// Example: strncmp("aa", "aA", 1) == 0     At most 1 character
	// Example: strncmp("a", "A", 1) > 0        ASCII order
	// Example: strncmp("aa", "a", 3) > 0       Differ in length

	/**
	* -2
	*/
	int strncmp(String s1, String s2, int n){
	    if(s1 == null || s2 == null || n < 0){
	        return -2;        
	    }
	    
	    int length = n;
	    if(s1.length < length){
	        length = s1.length;
	    }
	    if(s2.length < length){
	        length = s2.length;
	    }

	    for(int i = 0; i < length; i++){
	        if(s1.charAt(i) == s2.charAt(i)){
	            continue;
	        }else if(s1.charAt(i) - s2.charAt(i) > 0){
	            return 1;
	        }else{
	            return -1;
	        }
	    }

	    //if n is smaller than both s1 s2's length
	    if(length == n){
	        return 0;
	    }else if(length < s1.length){
	        //we don't fininsh s1 but finish s2
	        return 1;
	    }else if(length < s2.length){
	        //we don't finish s2 but finish s1
	        return -1;
	    }else{
	        return 0;
	    }
	}





	Assume you are using a revision system for your codebase.
	Revisions are identified by a positive increasing integer.

	You find a bug. How do you quickly identify which revision introduced it?

	You know for every revision, whether it has the bug or not:

	bool isGood(int revision);
	bool isBad(int revision);
	if (revision_1 < revision_2 && isBad(revision_2)) assert(isBad(revision_1));

	Implement:
	int findBadRevision(int start_rev = 0, int end_rev = latest_revision){
	    if(latest_revision < 0){
	        return ....
	    }
	    if(latest_revision == 0){
	        return 0;
	    }
	    return helper(0, lastest_revision);
	}


	int helper(int start, int end){
	    int mid = (start + end) / 2;
	    if(isBad(mid) && isGood(mid - 1)){
	        return mid;
	    }else if(isBad(mid)){
	        return helper(start, mid - 1);
	    }else{
	        return helper(mid + 1, end);
	    }
	}
















}
