package com.mrjaffesclass.apcs.mvc.template;
import com.mrjaffesclass.apcs.messenger.*;
/**
 * The model represents the data that the application uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {
  // Messaging system for the MVC
  private final Messenger mvcMessaging;
  // Model's data variables
  //private int lower;
  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    mvcMessaging.subscribe("view:checkStringAndInt:model", this);
  }
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("RCV (model): "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("RCV (model): "+messageName+" | No data sent");
    }
  }
}
