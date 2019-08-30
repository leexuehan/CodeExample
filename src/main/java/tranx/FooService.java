package tranx;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

/**
 * @author leexuehan on 2019/8/30.
 */
public class FooService {
    private PlatformTransactionManager transactionManager;

    public void serviceMethod(){
        TransactionDefinition definition;
        TransactionStatus tranxStatus = transactionManager.getTransaction(definition);

    }
}
