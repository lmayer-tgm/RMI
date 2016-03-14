package server.commands;

import java.io.Serializable;

/**
 * Führt eine Aufgabe aus (muss von Serializable erben!)
 * @author lmayer
 * @verison 12032016
 * @param <T>
 */
public interface Command<T> extends Serializable {

	void execute();
}
