import java.util.Arrays;

public class MockInterview {


    public static int threeSplit(int[] array){
        long [] prefixArrSum = new long[array.length];

        prefixArrSum[0] = array[0];
        for(int i=1; i<array.length; i++){
            prefixArrSum[i] = prefixArrSum[i-1] + array[i];
        }
        long expectedArraySum = prefixArrSum[array.length-1] / 3;

        int totalCount = 0;
        long suffixArrSum = 0;

        for(int j =array.length-1; j>1; j--){
            suffixArrSum += array[j];
            for(int i=0; i<j-1; i++){
                /*The condition satisfies because we know that the sum of all elements
                    is divisible by 3. Let n=sum of elements.
                    if a = array1, b=array2, and c=array3 
                     a + b + c = n
                    if a == n/3 && c == n/3 -> b == n/3
                */
                if(suffixArrSum == expectedArraySum && suffixArrSum == prefixArrSum[i]){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    /** This one is better because it is linear. We know that if the first array is sum/3, it does not matter how many 
     *  distinct ranges we have for the first array as the sum of the other two is going to remain the same.
     * then we check all cases when the sum from the first position to an arbitrary i is equal to sum*2/3 and 
     * everytime that happens we add the nomber of distinct lengths of the first array that satisfies.
     */
    public static int darioSol(int [] array){
        long sum = 0;
        for (int x : array)
            sum += x;
        long find = sum / 3;
        
        int cut1 = 0;
        int total = 0;
        sum = 0;
        for (int i = 0; i < array.length-1; i++)
        {
            int x = array[i];
            sum += x;
            total += (sum == 2*find ? cut1 : 0);
            cut1 += (sum == find)?1:0;
        }
        return total;
    }



    public static void main(String[] args) {
//         Input:
// a: [0, -1, 0, -1, 0, -1]
// Expected Output:
// 4

int [] array = {0, -1, 0, -1, 0, -1};
System.out.println(Arrays.toString(array));
System.out.println(threeSplit(array));
System.out.println(darioSol(array));


// Input:
// a: [-1, 0, -1, 0, -1, 0]
// Expected Output:
// 4


int [] array1 = {-1, 0, -1, 0, -1, 0};
System.out.println(Arrays.toString(array1));
System.out.println(threeSplit(array1));
System.out.println(darioSol(array1));

// Input:
// a: [-1, 1, -1, 1, -1, 1, -1, 1]
// Expected Output:
// 3

int [] array2 = {-1, 1, -1, 1, -1, 1, -1, 1};
System.out.println(Arrays.toString(array2));
System.out.println(threeSplit(array2));
System.out.println(darioSol(array2));

// Input:
// a: [7, 8, 2, 25, -9, 12, 12]
// Expected Output:
// 0

int [] array3 = {7, 8, 2, 25, -9, 12, 12};
System.out.println(Arrays.toString(array3));
System.out.println(threeSplit(array3));
System.out.println(darioSol(array3));


// Input:
// a: [0, 0, 0, 0, 0]
// Expected Output:
// 6
int [] array4 = {0, 0, 0, 0, 0};
System.out.println(Arrays.toString(array4));
System.out.println(threeSplit(array4));
System.out.println(darioSol(array4));



int []  array5 = {      184138,
    -37745,
    82759,
    14851,
    79647,
    -91351,
    -9413,
    84612,
    -101031,
    -181203,
    -162841,
    -14357,
    -122060,
    -56837,
    -59344,
    95670,
    19230,
    -197053,
    -151794,
    -12451,
    1512,
    108952,
    -155189,
    -8121,
    43054,
    -25951,
    125440,
    28768,
    -42373,
    188365,
    150867,
    -38140,
    61777,
    186009,
    93565,
    -76218,
    -133893,
    -103795,
    -187274,
    -175627,
    -170204,
    -30250,
    151764,
    92036,
    9080,
    41271,
    -34582,
    75906,
    -176277,
    179547,
    152773,
    27776,
    -70639,
    -186460,
    134040,
    135416,
    196278,
    15198,
    -167083,
    190726,
    175444,
    -25970,
    -37584,
    130247,
    163481,
    -78746,
    123875,
    -127859,
    63643,
    131400,
    177022,
    -51120,
    -33714,
    -64067,
    -153262,
    -152369,
    -51938,
    173432,
    -101008,
    124992,
    -151945,
    -170175,
    182191,
    144348,
    -43276,
    -29398,
    143683,
    4763,
    164814,
    195818,
    28225,
    180864,
    -127334,
    37600,
    184790,
    4152,
    199588,
    133654,
    -18816,
    -121196,
    -67769,
    112234,
    57594,
    90858,
    199031,
    184334,
    112916,
    130951,
    -181948,
    -61114,
    74154,
    -44010,
    164849,
    163083,
    -165563,
    34566,
    -103124,
    185075,
    28700,
    -196978,
    -192354,
    -17883,
    -142522,
    -83792,
    43765,
    -183610,
    44134,
    -22779,
    192282,
    115221,
    12296,
    20731,
    98280,
    -89394,
    72800,
    -110352,
    -6289,
    54054,
    151191,
    53169,
    12397,
    -77496,
    76249,
    40497,
    8377,
    -134898,
    1345,
    -49669,
    72688,
    181648,
    113789,
    -91593,
    -85917,
    85401,
    76632,
    -71710,
    106722,
    -128521,
    -119048,
    37976,
    -72773,
    34432,
    40118,
    -153781,
    163824,
    149927,
    -83901,
    58599,
    114268,
    -195468,
    101292,
    37934,
    163551,
    -51514,
    93980,
    -178182,
    -152702,
    -76796,
    -114697,
    31344,
    -51611,
    -4632,
    -85532,
    -188408,
    163967,
    83255,
    34003,
    -175284,
    -60057,
    15142,
    175259,
    194554,
    -115806,
    47879,
    6083,
    -181421,
    31385,
    -154069,
    -280,
    187971,      184138,
    -37745,
    82759,
    14851,
    79647,
    -91351,
    -9413,
    84612,
    -101031,
    -181203,
    -162841,
    -14357,
    -122060,
    -56837,
    -59344,
    95670,
    19230,
    -197053,
    -151794,
    -12451,
    1512,
    108952,
    -155189,
    -8121,
    43054,
    -25951,
    125440,
    28768,
    -42373,
    188365,
    150867,
    -38140,
    61777,
    186009,
    93565,
    -76218,
    -133893,
    -103795,
    -187274,
    -175627,
    -170204,
    -30250,
    151764,
    92036,
    9080,
    41271,
    -34582,
    75906,
    -176277,
    179547,
    152773,
    27776,
    -70639,
    -186460,
    134040,
    135416,
    196278,
    15198,
    -167083,
    190726,
    175444,
    -25970,
    -37584,
    130247,
    163481,
    -78746,
    123875,
    -127859,
    63643,
    131400,
    177022,
    -51120,
    -33714,
    -64067,
    -153262,
    -152369,
    -51938,
    173432,
    -101008,
    124992,
    -151945,
    -170175,
    182191,
    144348,
    -43276,
    -29398,
    143683,
    4763,
    164814,
    195818,
    28225,
    180864,
    -127334,
    37600,
    184790,
    4152,
    199588,
    133654,
    -18816,
    -121196,
    -67769,
    112234,
    57594,
    90858,
    199031,
    184334,
    112916,
    130951,
    -181948,
    -61114,
    74154,
    -44010,
    164849,
    163083,
    -165563,
    34566,
    -103124,
    185075,
    28700,
    -196978,
    -192354,
    -17883,
    -142522,
    -83792,
    43765,
    -183610,
    44134,
    -22779,
    192282,
    115221,
    12296,
    20731,
    98280,
    -89394,
    72800,
    -110352,
    -6289,
    54054,
    151191,
    53169,
    12397,
    -77496,
    76249,
    40497,
    8377,
    -134898,
    1345,
    -49669,
    72688,
    181648,
    113789,
    -91593,
    -85917,
    85401,
    76632,
    -71710,
    106722,
    -128521,
    -119048,
    37976,
    -72773,
    34432,
    40118,
    -153781,
    163824,
    149927,
    -83901,
    58599,
    114268,
    -195468,
    101292,
    37934,
    163551,
    -51514,
    93980,
    -178182,
    -152702,
    -76796,
    -114697,
    31344,
    -51611,
    -4632,
    -85532,
    -188408,
    163967,
    83255,
    34003,
    -175284,
    -60057,
    15142,
    175259,
    194554,
    -115806,
    47879,
    6083,
    -181421,
    31385,
    -154069,
    -280,
    187971};

    System.out.println("Long Array");
System.out.println(threeSplit(array5));
System.out.println(darioSol(array5));

    }

}