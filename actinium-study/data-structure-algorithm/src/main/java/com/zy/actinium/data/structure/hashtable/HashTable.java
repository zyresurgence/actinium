package com.zy.actinium.data.structure.hashtable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/10/27 15:29
 */
public class HashTable {

    private final static Logger LOGGER = LoggerFactory.getLogger(HashTable.class);

    /**
     * 哈希表数组
     */
    private DataItem[] hashArray;

    private int arraySize;

    /**
     * 被删除的内容
     */
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        //被删除的内容是-1
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        LOGGER.info("Table : ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                LOGGER.info(hashArray[i].getKey() + " ");
            } else {
                LOGGER.info("** ");
            }
        }
    }

    public int hashFunction(int key) {
        //hash function
        return key % arraySize;
    }

    /**
     *  新增一条hash DataItem
     * @param item  DataItem
     */
    public void insert(DataItem item) {

        int key = item.getKey();
        int hashValue = hashFunction(key);
        //找到下一个不为空，且元素不是-1的数组下标
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            ++hashValue;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }

    public DataItem delete(int key) {
        int hashValue = hashFunction(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return temp;
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashValue = hashFunction(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

}
