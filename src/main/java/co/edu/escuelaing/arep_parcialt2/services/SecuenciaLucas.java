package co.edu.escuelaing.arep_parcialt2.services;

/**
 *
 * @author jeison.barreto
 */
public class SecuenciaLucas {

    public static Integer lucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return lucas(n - 1) + lucas(n - 2);
        }
    }
}
