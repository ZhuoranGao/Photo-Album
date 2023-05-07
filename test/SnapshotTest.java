import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Model.Snapshot;

import static org.junit.Assert.*;
/**
 * Build the class: SnapshotTest.
 */
public class SnapshotTest {

  private Snapshot snapshot;

  /**
   * Build the class: SnapshotTest.
   */
  @Before
  public void setUp() throws Exception {
    snapshot = new Snapshot("First");
  }

  /**
   * Build the class: getId.
   */
  @Test
  public void getId() {
    Calendar calendarId = Calendar.getInstance();
    SimpleDateFormat formatterId = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.");
    String id = formatterId.format(calendarId.getTime())+"1";
    assertEquals(id,snapshot.getId());
  }

  /**
   * Build the class: getDescription.
   */
  @Test
  public void getDescription() {
    assertEquals("First",snapshot.getDescription());
  }

  /**
   * Build the class: testToString.
   */
  @Test
  public void testToString() {
    assertEquals("\n" +
            "Model.Snapshot ID: " +snapshot.getId()+"\n"+
            "Timestamp: " +snapshot.getTime()+"\n"+
            "Description: First\n" +
            "Shape Information:\n",snapshot.toString());
  }

}