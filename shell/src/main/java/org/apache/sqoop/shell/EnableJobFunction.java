/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.shell;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.sqoop.shell.core.Constants;
import org.apache.sqoop.validation.Status;

import static org.apache.sqoop.shell.ShellEnvironment.*;

/**
 * Handles disabling of a job object.
 */
@SuppressWarnings("serial")
public class EnableJobFunction extends SqoopFunction {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("static-access")
  public EnableJobFunction() {
    this.addOption(OptionBuilder
      .withDescription(resourceString(Constants.RES_PROMPT_JOB_ID))
      .withLongOpt(Constants.OPT_JID)
      .isRequired()
      .hasArg()
      .create('j'));
  }

  @Override
  public Object executeFunction(CommandLine line, boolean isInteractive) {
    client.enableJob(line.getOptionValue(Constants.OPT_JID), true);
    return Status.OK;
  }
}
