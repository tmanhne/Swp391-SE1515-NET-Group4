/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 VUDM               AuthorsDAO
 */
package interfaceDAO;

import java.util.ArrayList;

/**
 *This interface class used to contain some method used to implements in another
 * class
 * @author vudm
 */
public interface IAuthorsDAO {
    /**
     * This method used to get author by bookId from Authors table
     *
     * @param bookId is a <code>String</code>
     * @return account is a ArrayList <code>authors</code>
     * @throws java.lang.Exception
     */
    public ArrayList<String> getAuthorsByBookId(String bookId) throws Exception;
}
