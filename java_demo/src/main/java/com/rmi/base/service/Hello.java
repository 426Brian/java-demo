package com.rmi.base.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Brian in 13:02 2018/4/30
 */
public interface Hello extends Remote {
    void printMsg() throws RemoteException;
}
