/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Uffe
 */
public interface Map<k, v> {
    public void put(k key, v value);
    public v get(k key);
    public int size();
}
