package imagecrypthillchiper;
 

public class Matrix
{
 
private static String fillString( String in, int len )
{
	String out = new String(in);
	while ( out.length() < len )
		out = " " + out;
	return(out);
}
 
public static String toString( int[][] matrix )
{
	String retVal = "";
	int m = matrix.length;
	int n = matrix[0].length;
	for ( int i = 0; i < m; ++i )
	{
		for ( int j = 0; j < n; ++j )
		{
			retVal += fillString(Integer.toString(matrix[i][j]), 24);
		}
		retVal += "\n";
	}
	return(retVal);
}
 
public static double[][] add( double[][] mat1, double[][] mat2 )
{
	int m = mat1.length;
	int n = mat1[0].length;
	double[][] matres = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		matres[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			matres[i][j] = mat1[i][j] + mat2[i][j];
	}
	return(matres);
}

 
public static double[][] sub( double[][] mat1, double[][] mat2 )
{
	int m = mat1.length;
	int n = mat1[0].length;
	double[][] matres = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		matres[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			matres[i][j] = mat1[i][j] - mat2[i][j];
	}
	return(matres);
}

 
public static double[][] mult( double[][] mat1, double[][] mat2 )
{
	int m = mat1.length;
	int n = mat1[0].length;
	int o = mat2[0].length;
	double[][] matres = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		matres[i] = new double[o];
		for ( int j = 0; j < o; ++j )
		{
			matres[i][j] = 0.0f;
			for ( int k = 0; k < n; ++k )
				matres[i][j] += mat1[i][k] * mat2[k][j];
		}
	}
	return(matres);
}

public static int[][] mult( int[][] mat1, int[][] mat2 )
{
	int m = mat1.length;
	int n = mat1[0].length;
	int o = mat2[0].length;
	int[][] matres = new int[m][];
	for ( int i = 0; i < m; ++i )
	{
		matres[i] = new int[o];
		for ( int j = 0; j < o; ++j )
		{
			matres[i][j] = 0;
			for ( int k = 0; k < n; ++k )
				matres[i][j] += mat1[i][k] * mat2[k][j];
		}
	}
	return(matres);
}

public static int[] mult( int[][] mat, int[] vec )
{
	int m = mat.length;
	int n = mat[0].length;
	int[] vecres = new int[m];
	for ( int i = 0; i < m; ++i )
	{
		vecres[i] = 0;
		for ( int j = 0; j < n; ++j )
			vecres[i] += mat[i][j] * vec[j];
	}
	return(vecres);
}
 
public static double[] mult( double[][] mat, double[] vec )
{
	int m = mat.length;
	int n = mat[0].length;
	double[] vecres = new double[m];
	for ( int i = 0; i < m; ++i )
	{
		vecres[i] = 0.0f;
		for ( int j = 0; j < n; ++j )
			vecres[i] += mat[i][j] * vec[j];
	}
	return(vecres);
}

 
public static double[][] scale( double[][] mat, double fac )
{
	int m = mat.length;
	int n = mat[0].length;
	double[][] res = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		res[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			res[i][j] = mat[i][j] * fac;
	}
	return(res);
}

 
public static double[][] random( int m, int n )
{
	double[][] matres = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		matres[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			matres[i][j] = Math.random();
	}
	return(matres);
}

 
public static double[][] newMatrix( int m, int n )
{
	double[][] res = new double[m][];
	for ( int i = 0; i < m; ++i )
		res[i] = new double[n];
	return(res);
}

 
public static double[][] newMatrix( int m, int n, double val )
{
	double[][] res = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		res[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			res[i][j] = val;
	}
	return(res);
}
 
public static double[][] transpose( double[][] mat )
{
	int m = mat.length;
	int n = mat[0].length;
	double[][] res = new double[n][];
	for ( int i = 0; i < n; ++i )
	{
		res[i] = new double[m];
		for ( int j = 0; j < m; ++j )
			res[i][j] = mat[j][i];
	}
	return(res);
}

 
public static double[][] clone( double[][] mat )
{
	int m = mat.length;
	int n = mat[0].length;
	double[][] res = new double[m][];
	for ( int i = 0; i < m; ++i )
	{
		res[i] = new double[n];
		for ( int j = 0; j < n; ++j )
			res[i][j] = mat[i][j];
	}
	return(res);
}

 
public static double[][] identity( int n )
{
	double[][] res = newMatrix(n, n, 0.0);
	for ( int i = 0; i < n; ++i )
		res[i][i] = 1.0;
	return(res);
}

 
public static double[][] diag( double[] diag )
{
	int n = diag.length;
	double[][] res = newMatrix(n, n, 0.0);
	for ( int i = 0; i < n; ++i )
		res[i][i] = diag[i];
	return(res);	
}

 
public static double[] getVecOfCol( double[][] mat, int j )
{
	int m = mat.length;
	double[] res = new double[m];
	for ( int i = 0; i < m; ++i )
		res[i] = mat[i][j];
	return(res);
}

 
public static int[] getVecOfRow( int[][] mat, int i )
{
	int n = mat[0].length;
	int[] res = new int[n];
	for ( int j = 0; j < n; ++j )
		res[j] = mat[i][j];
	return(res);
}
 
public static int getNumOfColumns( double[][] mat )
{
	return(mat[0].length);
}

 
public static int getNumOfRows( double[][] mat )
{
	return(mat.length);
}
 
public static double[][] square(
	double[][] mat )
{
	int m = Matrix.getNumOfRows(mat);
	int n = Matrix.getNumOfColumns(mat);
	double[][] res = Matrix.newMatrix(m, m);
	for ( int i = 0; i < m; ++i )
	{
		res[i][i] = 0.0;
		for ( int k = 0; k < n; ++k )
			res[i][i] += mat[i][k] * mat[i][k];
		for ( int j = 0; j < i; ++j )
		{
			res[i][j] = 0.0;
			for ( int k = 0; k < n; ++k )
				res[i][j] += mat[i][k] * mat[j][k];
			res[j][i] = res[i][j];
		}
	}
	return(res);
}

}
