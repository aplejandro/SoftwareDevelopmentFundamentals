package Week2_HW;

public class Squarelotron {
	int[][] squarelotron;
	int size;
	
	public Squarelotron (int n) {
		this.size = n;
		this.squarelotron = new int[n][n];
		int x = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				squarelotron[i][j] = x;
				x++;
			}
		}
	}
	
	/**
	 *This method performs the Upside-Down Flip of the squarelotron, as described above,
	  *and returns the new squarelotron. 
	  *The original squarelotron should not be modified (we will check for this).
	 */
	Squarelotron upsideDownFlip(int ring) {
		Squarelotron temp = new Squarelotron(size);
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	if ((i == ring - 1 || 
            		 i == size - ring || 
            		 j == ring - 1 || 
            		 j == size - ring) && 
            		!((i <= ring - 2 || 
            		  i >= size + 1 - ring || 
            		  j <= ring - 2 || 
            		  j >= size + 1 - ring))) {
                    temp.squarelotron[i][j] = this.squarelotron[size - i - 1][j];
                }
                else {
                    temp.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
        }
		return temp;
	}
	
	
	/**
	 *This method performs the Main Diagonal Flip of the squarelotron, 
	 *as described above, and returns the new squarelotron. 
	 *The original squarelotron should not be modified (we will check for this).
	 */
	Squarelotron mainDiagonalFlip(int ring) {
		Squarelotron temp = new Squarelotron(size);
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < this.size; j++) {
            	if ((i == ring - 1 || 
               		 i == size - ring || 
               		 j == ring - 1 || 
               		 j == size - ring) && 
               		!((i <= ring - 2 || 
               		  i >= size + 1 - ring || 
               		  j <= ring - 2 || 
               		  j >= size + 1 - ring))) {
                    temp.squarelotron[i][j] = this.squarelotron[j][i];
                }
                else {
                    temp.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
        }
		return temp;
	}
	
	/**
	 *The argument numberOfTurns indicates the number of times the entire squarelotron 
	 *should be rotated 90° clockwise. Any integer, including zero and negative integers, 
	 *is allowable as the argument. A value of -1 indicates a 90° counterclockwise rotation.
	 *This method modifies the internal representation of the squarelotron; 
	 *it does not create a new squarelotron.
	 */
	void rotateRight(int numberOfTurns) {
		numberOfTurns = (numberOfTurns % 4 + 4) % 4;
		for (int n = 0; n < numberOfTurns; n++) {
			Squarelotron temp = new Squarelotron(size);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					temp.squarelotron[j][size - 1 - i] = squarelotron[i][j]; 
				}
			}
			this.squarelotron = temp.squarelotron;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int ring = 2;
		Squarelotron original = new Squarelotron(n);
		Squarelotron upsidedown = new Squarelotron(n);
		Squarelotron diagonal = new Squarelotron(n);
		System.out.println("Original Matrix");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" "+original.squarelotron[i][j]+" ");
			}
			System.out.println();
		}
		if ((n <= 8 && n >=1) && (ring >=1 && ring <= 4)) {
			
			upsidedown = upsidedown.upsideDownFlip(ring);
			System.out.println("Upside Down Fliped Matrix");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" "+upsidedown.squarelotron[i][j]+" ");
				}
				System.out.println();
			}
			diagonal = diagonal.mainDiagonalFlip(ring);
			System.out.println("Main Diagonal Fliped Matrix");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" "+diagonal.squarelotron[i][j]+" ");
				}
				System.out.println();
			}
		}		
			
	}
		
}
