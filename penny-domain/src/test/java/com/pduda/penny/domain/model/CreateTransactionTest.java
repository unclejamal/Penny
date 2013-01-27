
import com.pduda.penny.toolkit.ProgrammerMistake;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.pduda.hamcrest.RegexMatcher.matches;
import com.pduda.penny.domain.model.Amount;
import com.pduda.penny.domain.model.Category;
import com.pduda.penny.domain.model.Transaction;

public class CreateTransactionTest {

    private final LocalDate anyNonNullDate = new LocalDate();
    private final Category anyNonNullCategory = new Category(
            "irrelevant category name");
    private final Amount anyNonNullAmount = Amount.cents(20);

    @Test
    public void provideAllKeyInformation() throws Exception {
        final Transaction transaction = new Transaction(
                anyNonNullDate, anyNonNullCategory,
                anyNonNullAmount);

        // Construction doesn't blow up
        assertEquals(anyNonNullDate, transaction.getDate());
        assertEquals(
                anyNonNullCategory, transaction.getCategory());
        assertEquals(anyNonNullAmount, transaction.getAmount());
    }

    @Test
    public void missingDate() throws Exception {
        try {
            new Transaction(
                    null, anyNonNullCategory, anyNonNullAmount);
            fail("Why can I create a transaction with no date?!");
        } catch (ProgrammerMistake success) {
            assertThat(
                    success.getMessage(), matches(
                    ".*A Transaction must have a date.*"));
        }
    }

    @Test
    public void missingCategory() throws Exception {
        try {
            new Transaction(
                    anyNonNullDate, null, anyNonNullAmount);
            fail(
                    "Why can I create a transaction with no "
                    + "category?!");
        } catch (ProgrammerMistake success) {
            assertThat(
                    success.getMessage(), matches(
                    ".*A Transaction must have a category.*"));
        }
    }

    @Test
    public void missingAmount() throws Exception {
        try {
            new Transaction(
                    anyNonNullDate, anyNonNullCategory, null);
            fail(
                    "Why can I create a transaction with no "
                    + "amount?!");
        } catch (ProgrammerMistake success) {
            assertThat(
                    success.getMessage(), matches(
                    ".*A Transaction must have an amount.*"));
        }
    }
}