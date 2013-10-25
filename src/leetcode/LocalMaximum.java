[ -3 *16 *4 17 15 0 20 5 ....]

---
[ 0 ]
[ 3 3 ]
local maxmimum: integer whose neighbor(s) are <= to it


/**
 * .....
*/
public int getLocalMax(int[] num){
    if(num == null || num.length == 0){
        return Integer.Min_Value;
    }
    
    if(num.length == 1){
        return num[0];
    }
    
    for(int i = 0; i < num.length; i++){
        //first element
        if(i == 0){
            if(num[i] >= num[i + 1]){
                return num[i];
            }
        }
        
        // last element
        else if(i == num.length - 1){
            if(num[i] >= num[i - 1]){
                return num[i];
            }
        }
        
        // mid element
        else if(num[i] >= num[i - 1] && num[i] >= num[i + 1]){
            return num[i];
        }
    }
}

int getLocalMaxII(int[] num){
    if(num == null || ..){
        ...
    }

    if(num.length == 1){
        return num[0];
    }
    
    return helperDriver(0, num.length - 1, num);
}

[ -3 *16 *4 17 18 0 20 5]

int helperDriver(int start, int end, int[] num){
    int mid = (start + end) / 2;
    if(mid == 0 && num[mid] >= num[mid + 1]){
        return num[mid];
    }
    else if(mid == num.length - 1 && num[mid] >= num[mid - 1]){
        return num[mid];
    }
    
    else if(num[mid] >= num[mid - 1] && num[mid] >= num[mid + 1]){
        return num[mid];
    }
    
    if(num[mid - 1] >= num[mid]){
        return helperDriver(start, mid - 1, num);
    }else{
        return helperDriver(mid + 1, end, num);
    }
}