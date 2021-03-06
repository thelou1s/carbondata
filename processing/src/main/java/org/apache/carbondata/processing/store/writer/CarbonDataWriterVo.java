/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.carbondata.processing.store.writer;

import java.util.List;

import org.apache.carbondata.core.datastore.block.SegmentProperties;
import org.apache.carbondata.core.metadata.schema.table.column.ColumnSchema;
import org.apache.carbondata.processing.datamap.DataMapWriterListener;
import org.apache.carbondata.processing.store.CarbonDataFileAttributes;

/**
 * Value object for writing the data
 */
public class CarbonDataWriterVo {

  private String[] storeLocation;

  private int measureCount;

  private String tableName;

  private int NoDictionaryCount;

  private CarbonDataFileAttributes carbonDataFileAttributes;

  private String databaseName;

  private List<ColumnSchema> wrapperColumnSchemaList;

  private String carbonDataDirectoryPath;

  private int[] colCardinality;

  private SegmentProperties segmentProperties;

  private int tableBlocksize;

  private int bucketNumber;

  private long schemaUpdatedTimeStamp;

  private int taskExtension;

  private DataMapWriterListener listener;

  /**
   * @return the storeLocation
   */
  public String[] getStoreLocation() {
    return storeLocation;
  }

  /**
   * @param storeLocation the storeLocation to set
   */
  public void setStoreLocation(String[] storeLocation) {
    this.storeLocation = storeLocation;
  }

  /**
   * @return the measureCount
   */
  public int getMeasureCount() {
    return measureCount;
  }

  /**
   * @param measureCount the measureCount to set
   */
  public void setMeasureCount(int measureCount) {
    this.measureCount = measureCount;
  }

  /**
   * @return the tableName
   */
  public String getTableName() {
    return tableName;
  }

  /**
   * @param tableName the tableName to set
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  /**
   * @return the noDictionaryCount
   */
  public int getNoDictionaryCount() {
    return NoDictionaryCount;
  }

  /**
   * @param noDictionaryCount the noDictionaryCount to set
   */
  public void setNoDictionaryCount(int noDictionaryCount) {
    NoDictionaryCount = noDictionaryCount;
  }

  /**
   * @return the carbonDataFileAttributes
   */
  public CarbonDataFileAttributes getCarbonDataFileAttributes() {
    return carbonDataFileAttributes;
  }

  /**
   * @param carbonDataFileAttributes the carbonDataFileAttributes to set
   */
  public void setCarbonDataFileAttributes(CarbonDataFileAttributes carbonDataFileAttributes) {
    this.carbonDataFileAttributes = carbonDataFileAttributes;
  }

  /**
   * @return the databaseName
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * @param databaseName the databaseName to set
   */
  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  /**
   * @return the wrapperColumnSchemaList
   */
  public List<ColumnSchema> getWrapperColumnSchemaList() {
    return wrapperColumnSchemaList;
  }

  /**
   * @param wrapperColumnSchemaList the wrapperColumnSchemaList to set
   */
  public void setWrapperColumnSchemaList(List<ColumnSchema> wrapperColumnSchemaList) {
    this.wrapperColumnSchemaList = wrapperColumnSchemaList;
  }

  /**
   * @return the carbonDataDirectoryPath
   */
  public String getCarbonDataDirectoryPath() {
    return carbonDataDirectoryPath;
  }

  /**
   * @param carbonDataDirectoryPath the carbonDataDirectoryPath to set
   */
  public void setCarbonDataDirectoryPath(String carbonDataDirectoryPath) {
    this.carbonDataDirectoryPath = carbonDataDirectoryPath;
  }

  /**
   * @return the colCardinality
   */
  public int[] getColCardinality() {
    return colCardinality;
  }

  /**
   * @param colCardinality the colCardinality to set
   */
  public void setColCardinality(int[] colCardinality) {
    this.colCardinality = colCardinality;
  }

  /**
   * @return the segmentProperties
   */
  public SegmentProperties getSegmentProperties() {
    return segmentProperties;
  }

  /**
   * @param segmentProperties the segmentProperties to set
   */
  public void setSegmentProperties(SegmentProperties segmentProperties) {
    this.segmentProperties = segmentProperties;
  }

  /**
   * @return the tableBlocksize
   */
  public int getTableBlocksize() {
    return tableBlocksize;
  }

  /**
   * @param tableBlocksize the tableBlocksize to set
   */
  public void setTableBlocksize(int tableBlocksize) {
    this.tableBlocksize = tableBlocksize;
  }

  public int getBucketNumber() {
    return bucketNumber;
  }

  public void setBucketNumber(int bucketNumber) {
    this.bucketNumber = bucketNumber;
  }

  /**
   * @return
   */
  public long getSchemaUpdatedTimeStamp() {
    return schemaUpdatedTimeStamp;
  }

  /**
   * @param schemaUpdatedTimeStamp
   */
  public void setSchemaUpdatedTimeStamp(long schemaUpdatedTimeStamp) {
    this.schemaUpdatedTimeStamp = schemaUpdatedTimeStamp;
  }

  public int getTaskExtension() {
    return taskExtension;
  }

  public void setTaskExtension(int taskExtension) {
    this.taskExtension = taskExtension;
  }

  public void setListener(DataMapWriterListener listener) {
    this.listener = listener;
  }

  public DataMapWriterListener getListener() {
    return listener;
  }
}
