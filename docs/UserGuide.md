# JPO Operational Data Environment User Guide

**Submitted to**\
U.S. Department of Transportation (USDOT)\
Federal Highway Administration ITS JPO

**Prepared by**\
Booz Allen Hamilton\
8283 Greensboro Drive\
McLean, VA 22102

_Last updated February 7, 2019_

# Table of Contents

- [Version History](#version-history)
- [1 - Introduction](#introduction)
- [2 - Project Overview](#project-overview)
- [3 - System Overview](#system-overview)
- [4 - Audience](#audience)
- [5 - Glossary](#glossary)
- [6 - ODE DEVELOPMENT ENVIRONMENT](#ode-development-environment)
  - [6.1 - Java Development Tools](#java-development-tools)
  - [6.2 - Java](#java)
  - [6.3 - Eclipse IDE](#eclipse-ide)
  - [6.4 - Maven](#maven)
  - [6.5 - Git Version Control](#git-version-control)
  - [6.6 - Building ODE Software Artifacts](#building-ode-software-artifacts)
    - [6.6.1 - Open-Source Repository](#open-source-repository)
    - [6.6.2 - ASN.1 Java API](#asn-1-java-api)
    - [6.6.3 - Build and Deploy Procedure](#build-and-deploy-procedure)
    - [6.6.4 - ODE Application Properties](#ode-application-properties)
    - [6.6.5 - ODE Logging Properties](#ode-logging-properties)
- [7 - ODE Features](#ode-features)
  - [7.1 - Managing SNMP Devices](#managing-snmp-devices)
    - [7.1.1 - Query Parameters](#query-parameters)
    - [7.1.2 - API Details](#api-details)
    - [7.1.3 - Web Based View](#web-based-view)
    - [7.1.4 - Additional Features/ Discussion Points](#additional-features-discussion-points)
  - [7.2 - Logging Events](#logging-events)
    - [7.2.1 - Log Levels](#log-levels)
    - [7.2.2 - Logging Setup](#logging-setup)
    - [7.2.3 - Steps to turn on/off logging during application runtime](#steps-to-turn-on-off-logging-during-application-runtime)
  - [7.3 - IEEE 1609.2 Compliance](#ieee-1609-2-compliance)
  - [7.4 - SCMS Certificate Management](#scms-certificate-management)
  - [7.5 - Inbound Data Distribution](#inbound-data-distribution)
    - [7.5.1 - Inbound BSM Log File Processing and Distribution](#inbound-bsm-log-file-processing-and-distribution)
    - [7.5.2 - Inbound TIM Log File Processing and Distribution](#inbound-tim-log-file-processing-and-distribution)
    - [7.5.3 - Inbound Other Log File Processing and Distribution](#inbound-other-log-file-processing-and-distribution)
    - [7.5.4 - Inbound BSM - Test File Processing (HEX and JSON)](#inbound-bsm---test-file-processing-hex-and-json)
  - [7.6 - Probe Data Management](#probe-data-management)
    - [7.6.1 - PDM Broadcast Request Quick Start Guide](#pdm-broadcast-request-quick-start-guide)
  - [7.7 - Outbound TIM Broadcast](#outbound-tim-broadcast)
    - [7.7.1 - Outbound TIM to SDW Websocket Setup](#outbound-tim-to-sdw-websocket-setup)
    - [7.7.2 - Outbound TIM to S3 Bucket Setup](#outbound-tim-to-s3-bucket-setup)
    - [7.7.3 - TIM Broadcast Request Quick Start Guide](#tim-broadcast-request-quick-start-guide)
  - [7.8 - Privacy Protection Module (PPM)](#privacy-protection-module-ppm)
  - [7.9 - Data validation](#data-validation)
  - [7.10 - String S3 Depositor](#string-s3-depositor)
  - [7.11 - VSD to SDC UDP Deposit Service](#vsd-to-sdc-udp-deposit-service)
    - [7.11.1 - VSD Deposit Service Messages and Alerts](#vsd-deposit-service-messages-and-alerts)
  - [7.12 - VSD Receiver Service](#vsd-receiver-service)
    - [7.12.1 - VSD Receiver Service Messages and Alerts](#vsd-receiver-service-messages-and-alerts)
  - [7.13 - BSM Receive Service via UDP](#bsm-receive-service-via-udp)
    - [7.13.1 - BSM Receiver Service Messages and Alerts](#bsm-receiver-service-messages-and-alerts)
  - [7.14 - Security Services Module](#security-services-module)
- [8 - Appendix A: ODE Interface Specification](#appendix-a-ode-interface-specification)
  - [8.1 - File Copy Data Deposit](#file-copy-data-deposit)
    - [8.1.1 - Messages and Alerts](#messages-and-alerts)
  - [8.2 - ODE REST API](#ode-rest-api)
    - [8.2.1 - Upload BSM File](#upload-bsm-file)
    - [8.2.2 - MANAGE SNMP API](#manage-snmp-api)
    - [8.2.3 - Traveler Information Message (TIM) Interface](#traveler-information-message-tim-interface)
    - [8.2.4 - Probe Data Management Messages (PDM) Interface](#probe-data-management-messages-pdm-interface)
  - [8.3 - ODE Streaming API](#ode-streaming-api)
    - [8.3.1 - Direct Kafka Interface](#direct-kafka-interface)
    - [8.3.2 - ODE Output Schema Reference](#ode-output-schema-reference)
- [9 - References](#references)

<a name="version-history">

# 0 - Version History

| Version # | Implemented By | Revision Date | What Changed?                                                             |
|-----------|----------------|---------------|---------------------------------------------------------------------------|
| 0.1       | Hamid Musavi   |               | Initial draft                                                             |
| 0.2       | Hamid Musavi   | 3/6/2017      | Updated document for ODE-146                                              |
| 0.3       | ODE Team       | 3/14/2017     | Added outbound TIM documentation                                          |
| 0.4       | ODE Team       | 3/28/2017     | Added PDM documentation                                                   |
| 0.5       | Hamid Musavi   | 5/9/207       | Added support for System Design Documentation                             |
| 0.6       | ODE Team       | 5/23/2017     | Added PPM Documentation                                                   |
| 0.7       | ODE Team       | 5/30/2017     | Added VSD documentation                                                   |
| 0.8       | ODE Team       | 6/02/2017     | Added BSM documentation                                                   |
| 0.9       | ODE Team       | 8/28/2017     | Updated properties table. TIM/PDM REST details moved to Swagger document. |
| 0.10      | ODE Team       | 9/1/2017      | Added BSM log file handling                                               |
| 0.11      | ODE Team       | 10/31/2017    | Updated for open-ode                                                      |
| 0.12      | ODE Team       | 1/10/2018     | Updated SDC/SDW WebSockets end-point                                      |
| 0.13      | ODE Team       | 1/23/2018     | Documented changes related to schemaVersion 4                             |
| 0.14      | ODE Team       | 2/14/2018     | Added GZIP documentation                                                  |
| 0.15      | ODE Team       | 12/18/2018    | Added rsuUsername and rsuPassword properties                              |
| 0.16      | ODE Team       | 2/4/2019      | Removed deprecated properties. Added ode.kafkaDisabledTopics              |

<a name="introduction">

# 1 - Introduction

The JPO Operational Data Environment (ODE) product is being developed
under Agile Development Methodologies, using an open architecture
approach, in an open source environment. This document describes the
preliminary architectural design of the JPO ODE and its interfaces with
external systems including the TMC applications, field devices and
center services.

Note: This is a living document and will be updated throughout the life
of the JPO ODE project to reflect the most recent changes in the ODE
design and stakeholder feedback. All stakeholders are invited to provide
input to this document. Stakeholders may direct all input to the JPO
Product Owner at DOT, FHWA, JPO. To provide feedback, we recommend that
you create an "[issue](https://github.com/usdot-jpo-ode/jpo-ode/issues)"
in the project's GitHub repository
(<https://github.com/usdot-jpo-ode/jpo-ode/issues>). You will need a
GitHub account to create an issue. If you don't have an account, a
dialog will be presented to you to create one at no cost.

<a name="project-overview">

# 2 - Project Overview

An Operational Data Environment is a real-time data acquisition and
distribution software system that processes and routes data from
Connected-X devices -- including connected vehicles (CV), personal
mobile devices, infrastructure components, and sensors -- to subscribing
applications to support the operation, maintenance, and use of the
transportation system, as well as related research and development
efforts.

The ODE is intended to complement a connected vehicle infrastructure by
brokering, processing and routing data from various data sources,
including connected vehicles, field devices, Transportation Management
Center (TMC) applications and a variety of other data users. Data users
include but not limited to transportation software applications,
Research Data Exchange (RDE), US DOT Situation Data Warehouse.

As a data provisioning service, the ODE can provision data from
disparate data sources to software applications that have placed data
subscription requests to the ODE. On the other direction, the ODE can
accept data from CV applications and broadcast them to field devices
through Road Side Units (RSU) and US DOT Situation Data Warehouse which
in turn will transmit the data to Sirius XM satellites for delivery to
the connected vehicles in the field.

While provisioning data from data sources to data users, the ODE also
will perform necessary security / credential checks and, as needed, data
validation and sanitization.

-   Data validation is the process of making a judgment about the
    quality of the data and handling invalid data as prescribed by the
    system owners.

-   Data sanitization is the modification of data as originally received
    to reduce or eliminate the possibility that the data can be used to
    compromise the privacy of the individual(s) that might be linked to
    the data.

<a name="system-overview">

# 3 - System Overview

JPO ODE is an open-sourced software application that will enable the
transfer of data between field devices and backend TMC systems for
operational, monitoring, and research purposes. The system will enable
applications to submit data through a variety standard interfaces as
illustrated in the figure below.

The mechanisms chosen for a specific deployment will depend on the
infrastructure, technical resources, and applications available to an
ODE environment.

The JPO-ODE will be designed to support the producers and consumers of
CV data as illustrated in Figure 1 below. ***The implementation timeline
for the identified interfaces will depend on the needs of the JPO ODE
customers (Wyoming CV Pilot site, initially) and the priority of these
capabilities to the JPO-ODE product owner.***

![](images/figure1.png)

Figure 1 - ODE System Data Producers and Consumers

<a name="audience">

# 4 - Audience

This document is intended for use by the ODE client applications.

<a name="glossary">

# 5 - Glossary

| Term      | Description                                                                                                                                                                                                                                                                                                                                          |
|-----------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| API       | Application Program Interface                                                                                                                                                                                                                                                                                                                        |
| ASN.1     | Abstract Syntax Notation One (ASN.1) is a standard and notation that describes rules and structures for representing, encoding, transmitting, and decoding data in telecommunications and computer networking                                                                                                                                        |
| Git       | Git is a free and open source distributed version control system designed to handle everything from small to very large projects with speed and efficiency.  https://git-scm.com/                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                                   
| JDK       | Java Development Kit                                                                                                                                                                                                                                                                                                                                 |
| JPO       | Joint Program Office                                                                                                                                                                                                                                                                                                                                 |
| JRE       | Java Runtime Environment                                                                                                                                                                                                                                                                                                                             |
| JVM       | Java Virtual Machine                                                                                                                                                                                                                                                                                                                                 |
| Kafka     | Apache Kafka is publish-subscribe messaging rethought as a distributed commit log.                                                                                                                                                                                                                                                                   |
| POJO      | Plain Old Java Object                                                                                                                                                                                                                                                                                                                                |
| SAE       | SAE International is a global association of more than 128,000 engineers and related technical experts in the aerospace, automotive and commercial-vehicle industries.                                                                                                                                                                               |
| J2735     | This SAE Standard specifies a message set, and its data frames and data elements specifically for use by applications intended to utilize the 5.9 GHz Dedicated Short Range Communications for Wireless Access in Vehicular Environments (DSRC/WAVE, referenced in this document simply as “DSRC”), communications systems. (SAE International 2016) |                                                                                                          
| SCP       | Secure Copy                                                                                                                                                                                                                                                                                                                                          |
| SDW       | Situation Data Warehouse                                                                                                                                                                                                                                                                                                                             |
| TIM       | Traveler Information Message                                                                                                                                                                                                                                                                                                                         |
| US DOT    | Unites States Department of Transportation                                                                                                                                                                                                                                                                                                           |
| WebSocket | WebSocket is designed to be implemented in web browsers and web servers, but it can be used by any client or server application. The WebSocket Protocol is an independent TCP-based protocol. Its only relationship to HTTP is that its handshake is interpreted by HTTP servers as an Upgrade request.                                              |
| ZooKeeper | Apache ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services.                                                                                                                                                                                    |

<a name="ode-development-environment">

# 6 - ODE Development Environment

<a name="java-development-tools">

### 6.1 - Java Development Tools

The ODE team uses Java as the primary programming language.

Tools:

- Java
- Eclipse IDE
- Git
- Maven
- GitHub: <https://github.com/usdot-jpo-ode/jpo-ode>

<a name="java">

### 6.2 - Java

Install Java Development Kit (JDK) 1.8

<http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>

<a name="eclipse-ide">

### 6.3 - Eclipse IDE

Download and install Eclipse.

<https://eclipse.org>

Configure Eclipse to use Java 1.8 JDK. Local installation of Tomcat can
integrate with Eclipse and can help with prototyping or debugging the
application.

<a name="maven">

### 6.4 - Maven

Maven is a build and dependency management tool. It is recommended that
a Maven plug-in is installed with your IDE so that your IDE is Maven
"aware". Newer versions of eclipse (Luna and later versions) comes
pre-installed with a Maven plug-in.

Download and install Maven: <https://maven.apache.org/>

<a name="git-version-control">

### 6.5 - Git Version Control

The ODE software is maintained and version controlled using GIT version
control system.

Recommend clients:

- Tortoise Git

- Source Tree

- GitHub Windows Desktop Application

- Git Extensions

It is recommended that GIT plug-ins are installed with your IDE so that
your IDE is Git "aware". Newer versions of eclipse (Luna and later
versions) comes pre-installed with a Git plug-in.

<a name="building-ode-software-artifacts">

### 6.6 - Building ODE Software Artifacts

The ODE source code is maintained in several separate Git repositories.
Instructions for obtaining and installing the following repositories can
be found in the jpo-ode/README.md document:

| Repository     | Visibility | Description             | Source                                            |
|----------------|------------|-------------------------|---------------------------------------------------|
| jpo-ode        | public     | Main repository         | <https://github.com/usdot-jpo-ode/jpo-ode>        |
| jpo-s3-deposit | public     | S3 depositor service    | <https://github.com/usdot-jpo-ode/jpo-s3-deposit> |
| jpo-cvdp       | public     | PII sanitization module | <https://github.com/usdot-jpo-ode/jpo-cvdp>       |
| asn1\_codec    | public     | ASN.1 encoder/decoder   | <https://github.com/usdot-jpo-ode/asn1_codec>     |

<a name="open-source-repository">

#### 6.6.1 - Open-Source Repository

The ODE deployment artifact consists of one of more jar files that make
up the collection of software modules and service components. Initially,
there will be only one executable jar file (one micros service) but in
the future as the ODE functionality expands it is envisioned that
additional services be introduced in separate jar files. Each service
component jar file will be a standalone "uber-jar" that contains all
necessary dependent jar files. The jar file will be deployable to a
physical or virtual server as well as within a Docker container.

The following components make up the JPO ODE software:

- jpo-ode-common: this component contains all the common classes used
  by other jpo-ode components. *This component is the lowest common
  denominator and never depends on any other jpo-ode component.*

- jpo-ode-core: this component contains the core functions carried out
  by the jpo-ode.

- jpo-ode-plugins: this component contains the plug-in modules.

- jpo-ode-svcs: this component and similar future components are the
  actual service components. This component is always a Spring
  Framework application and implements a specific service.

- asn1_codec: this component is a standalone module able to
  subscribing to encoded ASN.1 messages and publishing decoded data.
  The component is also capable of encoding and publishing them to the
  ODE and other applications. This module will replace the private
  repository jpo-ode-private.

<a name="asn1-java-api">

#### 6.6.2 - ASN.1 Java API

The data uploaded or deposited to the ODE from the connected vehicles
(CV) and the road-side units (RSU) is encoded in ASN.1 format. In order
for the ODE to utilize the data, it must be able to decode the data from
ASN.1 format into a more generic format, in this case Plain Old Java
Objects (POJOs). ODE utilizes an open-source ASN.1 codec library
provided on GitHub at <https://github.com/vlm/asn1c> . ODE team has
built a standalone C/C++ module that uses this library to perform all
required encoding and decoding needs of the application. The module is a
submodule of ODE, also provided on GitHub:
<https://github.com/usdot-jpo-ode/asn1_codec>

<a name="build-and-deploy-procedure">

#### 6.6.3 - Build and Deploy Procedure

Follow the steps in jpo-ode/README.md Getting Started guide for building
and deploying the JPO-ODE services.

<a name="ode-application-properties">

#### 6.6.4 - ODE Application Properties

JPO ODE configuration can be modified in a number of ways.

1. You can specify the configuration parameters in a file named
   *application.properties* located in the same directory from which
   the application is launched.

2. You may specify properties as command line options in the form of
   *\--ode.propertyName=propertyValue. For example, add
   ode.DdsCasUsername=fred.flintstone\@stone.age*

3. *You may* specify properties as system environment variables in the
   form of *ode.DdsCasUsername=fred.flintstone\@stone.age.*

Other properties not specific to the ODE can also be defined in a
similar way but without the *ode* prefix.

Current ODE properties and their default are defined in OdeProperties
class. The property name is the name of the OdeProperties class instance
parameter.

The following table describes all the ODE properties currently
available.

*Table 1 - ODE Application Properties*

| Name                                     | Default Value                                                                                 | Required               | Description                                                                                                                                                                                                                                                                                                                               |
|------------------------------------------|-----------------------------------------------------------------------------------------------|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ode.kafkaBrokers                         | $DOCKER_HOST_IP:9092                                                                          | X                      | List of kafka brokers and ports                                                                                                                                                                                                                                                                                                           |
| ode.uploadLocationRoot                   | ./uploads                                                                                     |                        | Location of the shared directory where ODE monitors for files to ingest.                                                                                                                                                                                                                                                                  |
| ode.uploadLocationObuLog                 | ./uploads/bsmlog                                                                              |                        | Specific location for OBU log files with header fields to specify direction, UTC timestamp, and other metadata                                                                                                                                                                                                                            |
| ode.pluginsLocations                     | ./plugins                                                                                     |                        | Location of the jar files for ODE plugins.                                                                                                                                                                                                                                                                                                |
| ode.kafkaProducerType                    | async                                                                                         |                        | Specifies whether publishing to Kafka will be synchronous (i.e. blocking until the data has been persisted) or asynchronous (i.e. publish and forget). Valid values are: sync or async. Sync will generally be slower but more reliable, async is faster with the risk of losing data if kafka crashes during the write operation.        |
| ode.ddsCasUsername                       | null                                                                                          | X                      | Username to be used for authentication when interfacing with Situation Data Warehouse                                                                                                                                                                                                                                                     |
| ode.ddsCasPassword                       | null                                                                                          | X                      | Password to be used for authentication when interfacing with Situation Data Warehouse (SDW)                                                                                                                                                                                                                                               |
| ode.ddsCasUrl                            | https://cas.cvmvp.com/accounts/v1/tickets                                                     |                        | URL of the US DOT security server.                                                                                                                                                                                                                                                                                                        |
| ode.ddsWebsocketUrl                      | wss://webapp.cvmvp.com/whtools/websocket                                                      |                        | URL of the US DOT SDW WebSockets API                                                                                                                                                                                                                                                                                                      |
| ode.sdcIp                                | 104.130.170.234                                                                               |                        | IPv4 address of SDC                                                                                                                                                                                                                                                                                                                       |
| ode.sdcPort                              | 46753                                                                                         |                        | Destination port of SDC                                                                                                                                                                                                                                                                                                                   |
| ode.bsmReceiverPort                      | 46800                                                                                         |                        | The UDP port that ODE will use to listen to BSM messages.                                                                                                                                                                                                                                                                                 |
| ode.bsmBufferSize                        | 500                                                                                           |                        | Size of the buffer allocated for receiving BSM messages through UDP interface                                                                                                                                                                                                                                                             |
| ode. kafkaTopicVsdPojo                   | AsnVsdPojo                                                                                    |                        | The topic that contains VSDs if ode.enabledVsdKafkaTopic is enabled.                                                                                                                                                                                                                                                                      |
| ode.vsdBufferSize                        | 500                                                                                           |                        | Size of the buffer allocated for receiving VSD messages through UDP interface                                                                                                                                                                                                                                                             |
| ode.vsdReceiverPort                      | 46753                                                                                         |                        | The UDP port that ODE will use to listen to VSD messages.                                                                                                                                                                                                                                                                                 |
| ode.vsdDepositorPort                     | 5555                                                                                          |                        | The UDP port that ODE will use to send VSD messages to SDC for deposit.                                                                                                                                                                                                                                                                   |
| ode.vsdTrustport                         | 5556                                                                                          |                        | The UDP port that ODE will use to establish trust with the SDC for VSD messages.                                                                                                                                                                                                                                                          |
| ode.caCertPath                           |                                                                                               |                        |                                                                                                                                                                                                                                                                                                                                           |
|                                          | null                                                                                          | X                      | path/to/CaCertFile or define env variable ${ODE_CA_CERT_PATH}                                                                                                                                                                                                                                                                             |
| ode.selfCertPath                         | null                                                                                          | X                      | path/to/selfCertFile or define env variable ${ODE_SELF_CERT_PATH}                                                                                                                                                                                                                                                                         |
| ode.selfPrivateKeyReconstructionFilePath | null                                                                                          | X                      | path/to/selfPrivateKeyReconstructionFile or define env variable ${ODE_SELF_PRIVATE_KEY_RECONSTRUCTION_FILE_PATH}                                                                                                                                                                                                                          |
| ode.selfSigningPrivateKeyFilePath        | null                                                                                          | X                      | path/to/selfSigningPrivateKeyFile or define env variable ${ODE_SELF_SIGNING_PRIVATE_KEY_FILE_PATH}                                                                                                                                                                                                                                        |
| ode.isdBufferSize                        | 500                                                                                           |                        | Size of the buffer allocated for receiving ISD messages through UDP interface                                                                                                                                                                                                                                                             |
| ode.isdReceiverPort                      | 46801                                                                                         |                        | The UDP port that ODE will use to listen to ISD messages.                                                                                                                                                                                                                                                                                 |
| ode.isdDepositorPort                     | 6666                                                                                          |                        | The UDP port that ODE will use to send ISD messages to SDC for deposit.                                                                                                                                                                                                                                                                   |
| ode.isdTrustPort                         | 6667                                                                                          |                        | The UDP port that ODE will use to establish trust with the SDC for ISD messages.                                                                                                                                                                                                                                                          |
| ode.dataReceiptBufferSize                | null                                                                                          |                        | Size of the buffer allocated for receiving ISD receipt messages through UDP interface                                                                                                                                                                                                                                                     |
| ode.depositSanitizedBsmToSdc             | false                                                                                         |                        | Enable/disable packaging of BSMs into VSDs and depositing VSDs to SDC                                                                                                                                                                                                                                                                     |
| ode.serviceRespExpirationSeconds         | 10                                                                                            |                        | Number of seconds the trust manager will wait to receive service request response before timing out.                                                                                                                                                                                                                                      |
| Kafka Topics                             | See Section 8.3.1.1                                                                           |                        | See Section 8.3.1.1                                                                                                                                                                                                                                                                                                                       |
| ode.securitySvcsSignatureUri             | null                                                                                          |                        | The URI for signing data using the jpo-security-svcs module. Normally doesn't need to be set because ODE will calculate it based on DOCKER_HOST_IP. If the service is deployed outside Docker, it should be set to http://host:ip/sign of the server it's running on. If you do not want to sign the data set this property to UNSECURED. |
| ode.rsuUsername                          | null                                                                                          | If not present in JSON | The SNMP username used to authenticate with an RSU when depositing, deleting, or querying TIMs.                                                                                                                                                                                                                                           |
| ode.rsuPassword                          | null                                                                                          | If not present in JSON | The SNMP password used to authenticate with an RSU when depositing, deleting, or querying TIMs.                                                                                                                                                                                                                                           |
| ode.kafkaTopicsDisabled                  | topic.OdeBsmRxPojo, topic.OdeBsmTxPojo, topic.OdeBsmDuringEventPojo,topic.OdeTimBroadcastPojo |                        | List of topics to be disabled from publishing.                                                                                                                                                                                                                                                                                            |

<a name="ode-logging-properties">

#### 6.6.5 - ODE Logging Properties

ODE produces two log files:

1.  The application log file: for overall application health monitoring

2.  Events log file: for tracking and monitoring major data events such
    as the flow of data files through the system

The configuration of the loggers is done via *logback.xm*l file. The
default logback.xml is located in the *src/main/resources* directory of
the source code as well as in the *BOOT-INF\\classes\\* directory of the
executable jar file. To modify the default values, you can modify the
source *src/main/resources/logback.xml* file before building the
software or place a different *logback.xml* file with the modified
values in the working directory of the application.

<a name="ode-features">

# 7 - ODE Features

JPO ODE provides the following features and functions to TMC
applications:

1.  Managing SNMP Devices

2.  Logging Events

3.  IEEE 1609.2 Compliance

4.  SCMS Certificate Management

5.  Inbound BSM Distribution

6.  Inbound Probe Data Distribution

7.  Outbound Probe Device Management

8.  Outbound TIM Broadcast

9.  Inbound TIM Distribution

10. Data Validation

11. Data Sanitization

<a name="managing-snmp-devices">

### 7.1 - Managing SNMP Devices

Over SNMP Protocol, the ODE can ping and assess the health of an
existing Road Side Unit to ensure the system is up and running. To
trigger a specific heartbeat call, the ODE provides two separate
interfaces to deploy a message to an RSU.

<a name="query-parameters">

##### 7.1.1 - Query Parameters

To make a heartbeat call, a user must provide two pieces of information
to identify the device and the information the user is attempting to
capture.

**IP Address:** The published ip address of the device.

**SNMP OID Value:** The numeric OID of the desired information.

*The OIDs for the RSUs are specified in the DSRC Roadside Unit (RSU)
Specifications Document v4.1. The units also respond to ISO standard
OIDs, as demonstrated in the screenshot below.*

<a name="api-details">

##### 7.1.2 - API Details

To get the results from the SNMP protocol, submit a RESTful GET request
to the route listed below.

/rsuHeartbeat?ip=\<ip\_address\>&oid=\<oid\_string\>

You should receive a detailed plain text response that looks like the
following example. If the device is off, a 4 second timeout will occur
and the ODE will indicate this with an \"\[ERROR\] Empty response\"
message. (This specific OID returns the amount of time since the device
was last powered on)

\[1.3.6.1.2.1.1.3.0 = 0:05:12.59\]

<a name="web-based-view">

#### 7.1.3 - Web Based View

An additional method way to interact with the heartbeat service is
through the existing web interface located at the root of the
application. On it, a user will see a section for RSU SNMP Query and may
enter in the same IP and OID information as the API Endpoint.

<a name="additional-features-discussion-points">

#### 7.1.4 - Additional Features/ Discussion Points

-   SNMP v3 discussion needed surrounding v2, v1 support

    -   V3 username/password

-   Should the responses from the application be in a standard format?
    (JSON)

<a name="logging-events">

### 7.2 - Logging Events

ODE uses Logback logging framework to log application and data events.

<a name="log-levels">

#### 7.2.1 - Log Levels

1.  ALL - Logger reports to all levels below

2.  DEBUG - Logger reports debug information

3.  ERROR - Logger reports error events that may still allow the
    application to continue running

4.  FATAL - Logger reports fatal errors that will cause the application
    to abort

5.  INFO - Logger reports informational messages

6.  OFF - Turns off the logger

7.  TRACE - Logger reports more specific debug information

8.  WARN - Logger reports application warnings

<a name="logging-setup">

#### 7.2.2 - Logging setup

-   As it stands, the current logging framework has two separate log
    files. The first log file is for application output called ode.log.
    Application debug information and backend service messages are
    output to this file. The second log file, Events.log contains
    informational messages pertaining to the services a message goes
    through inside of the system.

-   The current setup of the logging framework is very minimal. It
    contains four loggers and two appenders for the respective files.
    The logback framework has the ability to set time based file
    deletion, and rolling archive file naming. For the full list of
    features visit this URL: <https://logback.qos.ch/manual/>

<a name="steps-to-turn-on-off-logging-during-application-runtime">

#### 7.2.3 - Steps to turn on/off logging during application runtime.

1.  Start ode, Kafka, and Zookeeper as normal.

2.  In a new terminal window run \"jconsole\".

3.  After the dialog box comes up asking for connection, click on the
    remote access button at the bottom.

4.  Input the ip address you set to be your DOCKER\_HOST\_IP:9090 (ex.
    0.0.0.0:9090).

5.  Click connect.

6.  Select insecure connection.

7.  Select the MBeans tab at the top.

8.  Expand the folder ch.qos.logback.classic until you get to Attributes
    and Operations.

9.  Open the operations Tab.

10. Select the reloadbyfilename option.

11. In the dialog box input the name of your logging configuration file.
    (Currently logback.xml)

12. Edit logback.xml inside of the docker container for ode and modifiy
    the log level for whatever logger you wish to turn off to \"OFF\".

13. Save the file and go back to the jconsole and click the button
    reloadbyfilename to submit changes.

<a name="ieee-1609-2-compliance">

### 7.3 - IEEE 1609.2 Compliance

As of this release, ODE supports signature validation of BSM data
received via file upload and UDP interfaces. To enable this
functionality, CA certificates must be installed and configured using
below properties or environment variables as described in section 6.6.3.

```
ode.caCertPath
ode.selfCertPath
ode.selfPrivateKeyReconstructionFilePath
ode.selfSigningPrivateKeyFilePath
```

Upon validation, the Boolean field variable validSignature in the
metadata field of OdeBsmData message will be set to true or false
according to the validation result.

<a name="scms-certificate-management">

### 7.4 - SCMS Certificate Management

TBD

<a name="inbound-data-distribution">

### 7.5 Inbound Data Distribution

ODE accepts Inbound BSMs, TIMs and other data types via File Copy Data
Deposit mechanism as described in section 8.1. Note that after files are
processed by the ODE, they are moved to either the backup sub-directory
upon success, or the "failed" sub-directory upon error. The ODE is
capable of accepting log files in both raw data format as well as in
GZIP-compressed format. Compressed files are detected automatically and
processed in the same way as normal files, no special actions are needed
by the user.

The ODE propagates received data to applications via a subscription
service provided by Kafka messaging hub. The ODE offers two Kafka
subscription formats, JSON and serialized Java objects (also referred to
as POJO). ODE uses Kryo serializer for serializing POJOs before
publishing. See section 8.3.1 for the topic names to which applications
can subscribe.

<a name="inbound-bsm-log-file-processing-and-distribution">

#### 7.5.1 - Inbound BSM Log File Processing and Distribution

1. bsmLogDuringEvent
  1. BSMs for event (10 seconds before, event, 10 seconds after all at 10 Hz) (purge first)
    1. Driver alert
    2. Received BSMs from remote vehicle(s), also record host vehicle BSMs
    3. If event is longer than 1-minute drop to 1 Hz for host and remove vehicles
    4. Add time to each record for all BSMs (from 1609.2 header)
2. bsmTx
  1. BSM once every 30 seconds (purge second)
    1. Add time to each record for all BSMs (from 1609.2 header)
3. rxMsg
  1. Received messages (purge third)
    1. Received BSMs from nearby OBUs are logged and deposited to the ODE via the file copy interface.

<a name="inbound-tim-log-file-processing-and-distribution">

#### 7.5.2 - Inbound TIM Log File Processing and Distribution

1. rxMsg
  1. Received messages (purge third)
    1. TIMs from RSU and Satellite, message, location, method of reception (Sat/RSU) and time, only log messages within 20-mile radius and only log first time message is received
2. dnMsg
  1. DNM (purge eight)
    1. Location, time, DNM (log first unique DNM for Distressed vehicle and for each relay/received vehicle)
    2. Top priority for sending this log
3. driverAlert
  1. We have a log for driver's alerts, it will need to flag alerts that were not given because of a higher priority alert (purge ninth)
    1. Location, time, alert (FCW, TIM, not DNM)

<a name="inbound-other-log-file-processing-and-distribution">

#### 7.5.3 Inbound Other Log File Processing and Distribution

**STATUS: These log messages have not yet been implemented.**

1. environmentMsg
  1. Environmental Log (purge seventh)
    1. Location, time, environmental log
    1. Second priority for sending this log
2. scms
  1. SCMS (purge fifth)
    1. Log connections to SCMS
3. systemLog
  1. System log (very PII sensitive, just for internal use and will have to be locked down and encrypted, may want to exclude collection of this once the pilot is working well) (purge sixth)
    1. Boot and shutdown location/time
    2. Application errors and re-starts
    3. OBU unique identifier
4. upgrades
  1. OBU upgrades (purge fourth)
    1. Log success/fail of firmware updates
    2. Log availability of firmware updates

<a name="inbound-bsm-text-file-processing-hex-and-json">

#### 7.5.4 - Inbound BSM - Text File Processing (HEX and JSON)

HEX and JSON file processing is no longer supported

<a name="probe-data-management">

### 7.6 - Probe Data Management

ODE accepts PDM messages and other metadata parameters for broadcasting
PDM messages via the REST API interface. The ODE accepts data elements
in JSON which are then sent via SNMP to an array of Roadside Units
(RSUs) which are also specified in that same JSON string.

<a name="pdm-broadcast-request-quick-start-guide">

#### 7.6.1 - PDM Broadcast Request Quick Start Guide

To run a local test of the PDM message API, please follow these
instructions.

1.  Start the ODE.

2.  Reference the Swagger documentation located in the /docs folder of
    the repo to view the specifications for the API call. If needed,
    paste the YAML file into http://editor.swagger.io to see a rendered
    webpage for the documentation.

3.  Use a web based REST tool such as Postman to send the PDM broadcast
    request to the ODE. Make sure the REST request body contains the
    "snmp" and "rsus" elements with valid IP addresses of the RSUs that
    you intend to send the message to.

4.  The REST interface will return a response indicating the request was
    executed successfully: {success: true}. If the request fails, you
    will receive an error message such as:\

```json
{
	"timestamp": 1489415494755,
	"status": 400,
	"error": "Bad Request",
	"exception": "us.dot.its.jpo.ode.traveler.TimMessageException",
	"message": "us.dot.its.jpo.ode.traveler.TimMessageException: Empty response from RSU 127.0 .0 .1",
	"path": "/tim"
}
```

<a name="outbound-tim-broadcast">

### 7.7 - Outbound TIM Broadcast

ODE accepts TIM messages and other metadata parameters for broadcasting
TIM messages via the REST API interface. The ODE accepts data elements
in JSON format from which a fully formed ASN.1 compliant J2735
TravelerInformation message will be constructed and sent to an array of
RSUs. The RSUs must be specified in the TIM broadcast message received
by the ODE. In addition to the RSU devices, the TIM message is also
deposited to the US DOT Situation Data Warehouse (SDW) from which the
SiriusXM satellites will pull from and broadcast to vehicles that are
not within range of RSUs. SDW parameters are also specified in the TIM
REST interface. Please refer to the Swagger file documentation for
details of a TIM REST interface.

<a name="outbound-tim-to-sdw-websocket-setup">

#### 7.7.1 - Outbound TIM to SDW Websocket Setup

1.  ODE **Configuration**: Update the
    effective application.properties file with username and password for
    Webapp2/sdw. Substitute your username and password
    for \<SDWUSERNAME\> and \<SDWPASSWORD\>, respectively.

ode.ddsCasUsername=\<SDWUSERNAME\>

ode.ddsCasPassword=\<SDWPASSWORD\>

OR defined the following command line arguments while launching
jpo-ode-svcs

\--ode.ddsCasUsername=\<SDWUSERNAME\>, \\

\--ode.ddsCasPassword=\<SDWPASSWORD\>

Or define the following system properties / environment variables

ode.ddsCasUsername=\<SDWUSERNAME\>

ode.ddsCasPassword=\<SDWPASSWORD\>

-   **RSU Enablement**: /tim REST service sends the TIM messages to RSUs
    if both "rsus" and "snmp" elements of the request body are defined
    and valid. If either "rsus" or "snmp" are missing, the request will
    not be sent to the RSUs.

-   **SDW Enablement**: /tim REST service sends the TIM messages to SDW
    if the "sdw" element of the request body is defined and valid. If
    "sdw" element is missing, the request will not be sent to the SDW.

<a name="outbound-tim-to-s3-bucket-setup">

#### 7.7.2 - Outbound TIM to S3 Bucket Setup

Depositing a TIM message to an S3 bucket can be done using the pre-built
jpo-s3-depositor repository. To set this service up:

1.  Follow the steps in the ODE README.md to clone and compile the S3
    depositor service.

2.  Set the following environment variables (and/or use the RDE prefixed
    variables, these prefixes are for guidance only and do not
    necessarily need to be a CVPEP or RDE bucket):

    -   CVPEP\_TIM\_S3\_ACCESS\_KEY\_ID

    -   CVPEP\_TIM\_S3\_SECRET\_ACCESS\_KEY

    -   CVPEP\_TIM\_S3\_BUCKET\_NAME

    -   CVPEP\_TIM\_S3\_DEPOSIT\_KEY

    -   CVPEP\_TIM\_S3\_TOPIC

3.  Follow the rest of the ODE setup steps. The S3 depositor service
    containers will be automatically created by docker-compose.

4.  Verify arrival of messages in S3 by visiting the AWS UI or an S3
    client application.

<a name="tim-broadcast-request-quick-start-guide">

#### 7.7.3 - TIM Broadcast Request Quick Start Guide

To run a local test of the TIM Message API, please follow these
instructions:

1.  Start the ODE with valid ode.ddsCasUsername and ode.ddsCasPassword
    in the effective application.properties file.

2.  Reference the Swagger documentation located in the /docs folder of
    the repo or at https://usdot-jpo-ode.github.io/ to view the
    specifications for the API call.

3.  Copy the curl command, run the python script, or use a web based
    REST tool such as Postman to send the TIM broadcast request to the
    ODE. Make sure the REST request body contains the "snmp" and "rsus"
    elements with valid IP addresses of the RSUs that you intend to send
    the message to as well as the required SDW parameters.

4.  The REST interface will return a response indicating the deposit
    success ("success":"true") or failure ("success":"false") for each
    RSU and the SDW deposit:

```json
{
	"rsu_responses": [{
		"target": "192.168.1.100",
		"success": "true",
		"message": "Success."
	}],
	"dds_deposit": {
		"success": "true"
	}
}
```

<a name="privacy-protection-module-ppm">

### 7.8 Privacy Protection Module (PPM)

PPM is a separate repository within the GitHub
[usdot-jpo-ode](https://github.com/usdot-jpo-ode) organization. ODE
interfaces with the PPM module via Kafka messaging hub. Please refer to
the GitHub repository <https://github.com/usdot-jpo-ode/jpo-cvdp> for
details. For instructions about configuration and integration of the PPM
with ODE, please refer to the ODE README file at the root of the GitHub
page <https://github.com/usdot-jpo-ode/jpo-ode> .

<a name="data-validation">

### 7.9 - Data validation

TBD

<a name="string-s3-depositor">

### 7.10 - String S3 Depositor

The ODE has the capability to deposit any string messages to any S3
buckets using the application in the jpo-s3-depositor repository. To
obtain and build this service, follow the instructions in the ODE
README.md document. Once downloaded and compiled, all the user must do
is set the relevant environment variables, the rest is managed
automatically by docker-compose.

Four example S3 depositor configurations are provided in the
docker-compose.yml file in the root of the jpo-ode directory, a BSM and
TIM depositor for both CVPEP and RDE: cvpep\_bsm\_s3dep,
rde\_bsm\_s3dep, cvpep\_tim\_s3dep, and rde\_tim\_s3dep. These example
templates are provided for convenience and guidance but may be
removed/commented out by adding a \# symbol to the front of each line,
or copied to create new a new S3 depositor.

<a name="vsd-to-sdc-udp-deposit-service">

### 7.11 - VSD to SDC UDP Deposit Service

ODE sends VSD message to SDC using UDP protocol. Unlike TCP, UDP is a
best effort delivery service which means that the protocol does not wait
for an acknowledgement from the receiver. The VSD depositor is
implemented as a module in the ODE and follows the VSD dialog for
depositing VSD message to US DOT Situation Data Clearinghouse (SDC)
specified by the Southeast Michigan Test Bed documentation available
upon request from <https://cvcs.samanage.com> and summarized below.

**VSD Deposit Dialog**

5.  ODE \-\-\-\-\--ServiceRequest\-\-\-\--\> SDC // ODE sends service
    request to SDC

6.  ODE \<\-\-\--ServiceResponse\-\-\-\-- SDC // ODE receives service
    response from SDC

7.  ODE \-\-\-\-\-\-\--VsdMessage\-\-\-\-\-\--\> SDC // ODE sends the
    actual VSD message to SDC

[Requirements for sending VSD message to SDC over UDP are the
following:]{.underline}

1.  IP address or Domain Name of the SDC server

2.  Port number of the SDC server

<a name="vsd-deposit-service-messages-and-alerts">

#### 7.11.1 - VSD Deposit Service Messages and Alerts

Table 1 provides a detailed list of the ODE Deposit Service messages and
alerts.

Table 1 -- VSD Deposit Service Messages and Alerts

| Message or Alert                                                        | Communication Method | Description                                                                                                                                                                                                                                | Criteria                                                                                                                                                      |
|-------------------------------------------------------------------------|----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| · "Error creating VSD depositor socket with port {}" · SocketException  | Application log file | When a VSD arrives over UDP, the VSD depositor service tries to create a new datagram socket with a given port. This error message is logged when ODE fails to create a new datagram socket due to port being bound to some other program. | If the port is already bound to some other program or if the socket creation fails for some other reason, this message is logged in the application log file. |
| · Error Sending VSD to SDC · SocketException                            | Application log file | When a datagram socket tries to send VSD to SDC, this error maybe logged if the socket fails to send VSD due Input Output Exception.                                                                                                       | If the datagram socket fails to send the VSD to SD due to IOException, this message is logged in the application log file.                                    |
| · Error Encoding VSD ServiceRequest · SocketException · SocketException | Application log file | When the depositor service modifies the received service request, it tries to encode the request before sending to SDC. This message is logged when the ODE fails to encode the service request properly.                                  | If ODE fails to encode the modified service request properly, this message is logged in the application log file.                                             |

<a name="vsd-receiver-service">

### 7.12 - VSD Receiver Service

The ODE receives VSD messages via UDP/IP at its VSD Receiver service.
This service will accept ServiceRequest and VehSitDataMessage datagrams.
Upon receipt of a ServiceRequest, the receiver works with the VSD
depositor service to forward the ServiceRequest to the SDC and await a
ServiceResponse. When the matching ServiceResponse is returned the ODE
forwards the response back to the sender. This completes the trust
establishment process. Once trust is established, the sender starts
sending VSD messages to ODE which then will be forwarded to the SDC.
Upon arrival of VSDs, the ODE also extracts BSMs from VSDs and publishes
them to the appropriate BSM Kafka topics.

Configuration options (set in application.properties) can be found in
Table 1 - ODE Application Properties.

![](images/figure2.png)

Figure 2 - VSD Dialog Flow Diagram

Notes for Figure 2:

-   Random Ports: These ports could have a range of values.

-   Port A: Can be configured in application.properties

-   Port B: Can be configured in application.properties

-   Service Request 1: Original request whose destination field contains
    Port D

-   Service Request 2: Modified request whose destination field contains
    Port A

-   Firewall rules should be configured to allow inbound and outbound
    ports for ODE.

<a name="vsd-receiver-service-messages-and-alerts">

#### 7.12.1 - VSD Receiver Service Messages and Alerts

Table 1 provides a detailed list of the VSD Receiver Service messages
and alerts.

Table 1 -- VSD Receiver Service Messages and Alerts

| Message or Alert                                                                            | Communication Method | Description                                                                                                                                                                                                                                                          | Criteria                                                                                                                                                      |
|---------------------------------------------------------------------------------------------|----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| · "Error creating socket with port {}" · SocketException                                    | Application log file | When the VSDM receiver is initialized, a datagram socket is created to listen for incoming messages from black box. This error message is logged when ODE fails to create a new datagram socket due to port being bound to some other program or some other reasons. | If the port is already bound to some other program or if the socket creation fails for some other reason, this message is logged in the application log file. |
| · Error receiving packet · IOException                                                      | Application log file | When the ODE waits for packets from black box, this error message may be logged if the datagram socket fails to receive any packets due to IOException with the socket.                                                                                              | If the listening datagram socket fails to receive incoming packets from black box, this message is logged in the application log file.                        |
| ·       Unknown message type received {}                                                    | Application log file | When the VSDM receiver receives a packet from black box, it decodes the packet first. This message is logged if the decoded packet is of type other than ServiceRequest or VehSitDataMessage.                                                                        | If the packet received from black box and decoded on the receiver end is of unknown message type, then this message is logged in the application log file.    |
| ·       Unable to decode UDP message {} ·DecodeFailedException ·DecodeNotSupportedException | Application log file | When ODE receives any packet from black box, the receiver service tries to decode the packet first. This message is logged if the decoder fails to properly decode the packet.                                                                                       | If the receiver service fails to properly decode the incoming packets from black box, this message is logged in the application log file.                     |
| · Unable to convert VehSitDataMessage bundle to BSM list. · IllegalArgumentException        | Application log file | When the receiver receives VSD, it tries to extract BSMs out of the VSD. This error message is logged if the VSD bundle doesn’t have any BSM records.                                                                                                                | If the VSDM receiver receives a VSD that doesn’t contain any BSM records, this message is logged in the application log file.                                 |
| · Unable to convert BSM · OssBsmPart2Exception                                              | Application log file | When the VSDM receiver extracts BSMs from VSD, it tries to convert the generic BSM into J2735BSM format. This error message is logged if the receiver fails to properly perform conversion to J2735BSM format.                                                       | If the VSDM receiver fails to convert generic BSM to J2735BSM, this message is logged in the application log file.                                            |

<a name="bsm-receive-service-via-udp">

### 7.13 - BSM Receive Service via UDP

The ODE receives BSM messages via UDP/IP at its BSM Receiver service on
the default port 46800 which can be changed through ode properties. BSM
dialog does not include trust establishment phase, hence the BSMs are
directly sent to ODE. Once BSMs are received, they will be published to
the BSM kafka topics. \[ODE-314\] BSM Process then consumes the BSMs
from the corresponding kafka topics. The consumed BSMs will then be
inserted into a hash map where the keys will be the temp ID of the BSM
and the value will be a queue of corresponding BSMs with the particular
tempID. When a BSM is inserted to the queue, it will check if the queue
has 10 BSMs. In the case that the queue has 10 BSMs, it will package
them into VSD and publish it to the VSD kafka topic. Else, it will wait
for more incoming BSMs.

<a name="bsm-receiver-service-messages-and-alerts">

#### 7.13.1 - BSM Receiver Service Messages and Alerts

Table 1 provides a detailed list of the BSM Receiver Service messages
and alerts.

Table 1 -- BSM Receiver Service Messages and Alerts

| Message or Alert                                   | Communication Method | Description                                                                                                                                                                                                                                                   | Criteria                                                                                                                                                      |
|----------------------------------------------------|----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Error creating socket with port {} SocketException | Application log file | When the BSM receiver is initialized, a datagram socket is created to listen for incoming messages from OBU. This error message is logged when ODE fails to create a new datagram socket due to port being bound to some other program or some other reasons. | If the port is already bound to some other program or if the socket creation fails for some other reason, this message is logged in the application log file. |
| Error receiving packet IOException                 | Application log file | When the ODE waits for packets from OBU, this error message may be logged if the datagram socket fails to receive any packets due to IOException with the socket.                                                                                             | If the listening datagram socket fails to receive incoming packets from OBU, this message is logged in the application log file.                              |
| Unknown message type received {}                   | Application log file | When the BSM receiver receives a packet from OBU, it decodes the packet first. This message is logged if the decoded packet is of type other than J2735Bsm.                                                                                                   | If the packet received from OBU and decoded on the receiver end is of unknown message type, then this message is logged in the application log file.          |

<a name="security-services-module">

### 7.14 - Security Services Module

ODE integrates with the
[jpo-security-svcs](https://github.com/usdot-jpo-ode/jpo-security-svcs)
(JSS) module for performing message signing, verification, encryption
and decryption. ODE sends TIM messages to JSS module to be signed before
broadcasting the message to RSUs and SDW. No new configuration
properties need to be set if the module and ODE run in Docker containers
on the same server. However, if they are running o different host
machines the property *ode.securitySvcsSignatureUri* must be set to
point to the JSS domain name or IP:Port number. The JSS module must,
however, be configured with the DNS name or IP:Port of the Green Hills
HSM security service URI. This property can be defined using the
environment variable *SEC\_CRYPTO\_SERVICE\_BASE\_URI*. It must be set
to [http://ip:port](http://ip:port) of the Green Hills appliance. If you
do not want to sign the data set
*SEC\_CRYPTO\_SERVICE\_BASE\_URI=UNSECURED*

<a name="appendix-a-ode-interface-specification">

# 8 - Appendix A: ODE Interface Specification

Field devices and TMC applications interface with the ODE for both
sending and receiving data to and from the ODE

Ode provides two methods of accepting data from field devices:

-   File copy: described in section 7.1

-   RESTful API: upload described in section 7.2

ODE provides several methods for the TMC applications (or any ODE client
application) to send and receive data to and from the ODE

-   RESTful API: upload described in section 7.2

-   Streaming API: described in section 7.3.

All of the above interfaces can be secured using SSL encryption.

<a name="file-copy-data-deposit">

### 8.1 - File Copy Data Deposit

The File copy method is achieved by providing a configurable location on
a shared file system where field devices will be able to deposit their
data files and log files for processing. The upload location is
specified by the application properties
ode.uploadLocationRoot/ode.uploadLocationObuLog. If not specified,
default locations would be uploads/obulog sub-directory off of the
location where ODE is launched. ODE creates the specified directories if
they do not exist.

Once the ODE processes the received file, it moves it to the
"ode.uploadLocationRoot/backup" sub-directory. The backed-up file is
renamed with a timestamp in milliseconds. If the ODE fails to process a
file, it instead moves the file to the "ode.uploadLocationRoot/failed"
sub-directory.

The files copied to "ode.uploadLocationObuLog" are treated as binary
data of variable length records conforming to the specification in
"data/wydotLogRecords.h" file. No header information is expected to
precede each record. As mentioned in section 7.5, the ODE is also
capable of accepting individual files compressed with GZIP. Note that
while the ODE will automatically detect and process GZIP files, it is
not capable of importing GZIP-TAR archives containing multiple files.

| Field Name         | Field Length (bytes) | Description                                                                            |
|--------------------|----------------------|----------------------------------------------------------------------------------------|
| logRecordType      | 1                    | Represents the type of log record as defined below:                                    |
|                    |                      | typedef enum _logRecordType {                                                          |
|                    |                      | DN_MSG = 0,                                                                            |
|                    |                      | ENVIRONMENT_MSG = 1,                                                                   |
|                    |                      | DRIVER_ALERT = 2,                                                                      |
|                    |                      | UPGRADES = 3,                                                                          |
|                    |                      | SYSTEM_LOG = 4,                                                                        |
|                    |                      | RX_MSG = 5,                                                                            |
|                    |                      | SCMS = 6,                                                                              |
|                    |                      | BSM_TX = 7,                                                                            |
|                    |                      | BSM_RX = 8                                                                             |
|                    |                      | } logRecordType;                                                                       |
|                    |                      |                                                                                        |
| direction          | 1                    | Represents the source of the BSM. 0 for EV(Tx), 1 for RV(Rx)                           |
| utctimeInSec       | 4                    | UTC time in seconds from Epoc 1/1/1970                                                 |
| mSec               | 2                    | milliseconds part of UTC time                                                          |
| verificationStatus | 1                    | contains a SecurtyStatusCode as defined below:                                         |
|                    |                      |                                                                                        |
|                    |                      | typedef enum _securityResultCode {             /* from dot3 */                         |
|                    |                      | success = 0,                                                                           |
|                    |                      | inconsistentInputParameters = 2,                                                       |
|                    |                      | spduParsingInvalidInput = 3,                                                           |
|                    |                      | spduParsingUnsupportedCriticalInformationField = 4,                                    |
|                    |                      | spduParsingCertificateNotFound = 5,                                                    |
|                    |                      | spduParsingGenerationTimeNotAvailable = 6,                                             |
|                    |                      | spduParsingGenerationLocationNotAvailable = 7,                                         |
|                    |                      | spduCertificateChainNotEnoughInformationToConstructChain = 8,                          |
|                    |                      | spduCertificateChainChainEndedAtUntrustedRoot = 9,                                     |
|                    |                      | spduCertificateChainChainWasTooLongForImplementation = 10,                             |
|                    |                      | spduCertificateChainCertificateRevoked = 11,                                           |
|                    |                      | spduCertificateChainOverdueCRL = 12,                                                   |
|                    |                      | spduCertificateChainInconsistentExpiryTimes = 13,                                      |
|                    |                      | spduCertificateChainInconsistentStartTimes = 14,                                       |
|                    |                      | spduCertificateChainInconsistentChainPermissions = 15,                                 |
|                    |                      | spduCryptoVerificationFailure = 16,                                                    |
|                    |                      | spduConsistencyFutureCertificateAtGenerationTime = 17,                                 |
|                    |                      | spduConsistencyExpiredCertificateAtGenerationTime = 18,                                |
|                    |                      | spduConsistencyExpiryDateTooEarly = 19,                                                |
|                    |                      | spduConsistencyExpiryDateTooLate = 20,                                                 |
|                    |                      | spduConsistencyGenerationLocationOutsideValidityRegion = 21,                           |
|                    |                      | spduConsistencyNoGenerationLocation = 22,                                              |
|                    |                      | spduConsistencyUnauthorizedPSID = 23,                                                  |
|                    |                      | spduInternalConsistencyExpiryTimeBeforeGenerationTime = 24,                            |
|                    |                      | spduInternalConsistencyextDataHashDoesntMatch = 25,                                    |
|                    |                      | spduInternalConsistencynoExtDataHashProvided = 26,                                     |
|                    |                      | spduInternalConsistencynoExtDataHashPresent = 27,                                      |
|                    |                      | spduLocalConsistencyPSIDsDontMatch = 28,                                               |
|                    |                      | spduLocalConsistencyChainWasTooLongForSDEE = 29,                                       |
|                    |                      | spduRelevanceGenerationTimeTooFarInPast = 30,                                          |
|                    |                      | spduRelevanceGenerationTimeTooFarInFuture = 31,                                        |
|                    |                      | spduRelevanceExpiryTimeInPast = 32,                                                    |
|                    |                      | spduRelevanceGenerationLocationTooDistant = 33,                                        |
|                    |                      | spduRelevanceReplayedSpdu = 34,                                                        |
|                    |                      | spduCertificateExpired = 35                                                            |
|                    |                      | } securityResultCode;                                                                  |
| curLocation        | location             | The location and speed of the vehicle receiving and reporting the event.               |
|                    |                      |                                                                                        |
|                    |                      | /* below elements units are as per SAE-2735 */                                         |
|                    |                      | typedef struct _location {                                                             |
|                    |                      | uint32_t latitude;                                                                     |
|                    |                      | uint32_t longitude;                                                                    |
|                    |                      | uint32_t elevation;                                                                    |
|                    |                      | uint16_t speed;                                                                        |
|                    |                      | uint16_t heading;                                                                      |
|                    |                      | } __attribute__((__packed__)) location;                                                |
| rxFrom             | rxSource             | The source of the message received:                                                    |
|                    |                      | typedef enum _rxSource {                                                               |
|                    |                      | RSU = 0,                                                                               |
|                    |                      | SAT, //XM satelite                                                                     |
|                    |                      | RV, /* for BSM rx */                                                                   |
|                    |                      | SNMP /* for SRM payload from backend/ODE*/                                             |
|                    |                      | } rxSource;                                                                            |
| latitude           | 4                    | The latitude of the vehicle receiving and reporting the event.                         |
| longitude          | 4                    | The longitude of the vehicle receiving and reporting the event.                        |
| elevation          | 4                    | The elevation of the vehicle receiving and reporting the event.                        |
| speed              | 2                    | The speed of the vehicle receiving and reporting the event.                            |
| heading            | 2                    | The heading of the vehicle receiving and reporting the event.                          |
| length             | 2                    | Length of data contained in the following payload                                      |
| payload            | 2302                 | RAW encoded data in 1609.2 format containing a MessageFrame header plus BSM or raw BSM |

ODE will use utctimeInSec plus mSec fields to populate the generatedAt
field of the output messages if and only if the payload is not signed
with a valid signature. If the payload contains a valid 1609.2
signature, the generationTime from 1609.2 header will be used.

<a name="messages-and-alerts">

#### 8.1.1 - Messages and Alerts

This interface uses the file system to copy a file from source to
destination. As a result, the messages and alerts generated by the copy
command are platform dependent. The following table describes a sample
set of exit codes returned by scp command but they may differ from the
system on which ODE is deployed and running.

Table 1 - SCP Return Codes

| 0  | Operation was successful                       |
|----|------------------------------------------------|
| 1  | General error in file copy                     |
| 2  | Destination is not directory, but it should be |
| 3  | Maximum symlink level exceeded                 |
| 4  | Connecting to host failed.                     |
| 5  | Connection broken                              |
| 6  | File does not exist                            |
| 7  | No permission to access file.                  |
| 8  | General error in sftp protocol                 |
| 9  | File transfer protocol mismatch                |
| 10 | No file matches a given criteria               |
| 65 | Host not allowed to connect                    |
| 66 | General error in ssh protocol                  |
| 67 | Key exchange failed                            |
| 68 | Reserved                                       |
| 69 | MAC error                                      |
| 70 | Compression error                              |
| 71 | Service not available                          |
| 72 | Protocol version not supported                 |
| 73 | Host key not verifiable                        |
| 74 | Connection failed                              |
| 75 | Disconnected by application                    |
| 76 | Too many connections                           |
| 77 | Authentication cancelled by user               |
| 78 | No more authentication methods available       |
| 79 | Invalid user name                              |

Table 2 - File Copy Data Deposit Messages and Alerts

| Message or Alert                                                                 | Communication Method | Description                                                                                                                                                                                                                 | Criteria                                                                                                                                                            |
|----------------------------------------------------------------------------------|----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| See Table 1 - SCP Return Codes for “copy” function Messages and Alerts           | Command exit code    | See Table 1 - SCP Return Codes for "copy" function Messages and Alerts                                                                                                                                                      | Platform Dependent                                                                                                                                                  |
| Post-copy: “IMPORTER - Failed to open or process file: {}” FileNotFoundException | Application log file | When a data file is copied into one of the ODE upload folders, ODE will try to open the file and process its content. This error message is logged when ODE fails to open the file due to file not being present.           | If the file does not exist when ODE starts to process it or for some other reason cannot be opened for reading, this message is logged in the application log file. |
| “IMPORTER - Failed to open or process file: {}” SecurityException                | Application log file | When a data file is copied into one of the ODE upload folders, ODE will try to open the file and process its content. This error message is logged when ODE fails to read the file due to lack of Java security privileges. | If a security manager exists and its checkRead method denies read access to the file, a message will be logged to the application log file.”                        |
| “IMPORTER - Failed to open or process file: {}” Error decoding data.             | Application log file | When a data file is copied into one of the ODE upload folders, ODE will try to open the file and process its content. This error message is logged when ODE fails to decode the data from ASN.1 format.                     | If the message is not encoded to the expected ASN.1 encoding, ODE will raise this error to indicate failure to decode the data.                                     |

<a name="ode-rest-api">

### 8.2 - ODE REST API

ODE exposes a RESTful API for use by clients for security,
administrative and data functions. Standard HTTP/HTTPS verbs such as
GET, POST, PUT, DELETE, etc., will be deployed for various functions.

1.  host: ip:port

2.  root context path: ode/api/rest

3.  schemes:

4.  \- http

5.  \- https

The REST API is documented using Swagger and can be found at
<https://usdot-jpo-ode.github.io/> - this document is also located in
the repository at docs/ODESwagger.yml.

![](images/figure3.png)

Figure 3 - ODE REST API Editor Tool

<a name="upload-bsm-file">

#### 8.2.1 - Upload BSM File

ODE provides a REST API interface to upload a file to the ODE. Refer to
[ODE REST API](https://usdot-jpo-ode.github.io/) online documentation
(<https://usdot-jpo-ode.github.io>) for details.

<a name="manage-snmp-api">

#### 8.2.2 - MANAGE SNMP API

Over an SNMP Protocol, the ODE can ping and assess the health of an
existing Road Side Unit to ensure the system is up and running. To
trigger a specific heartbeat call, the ODE provides two separate
interfaces to deploy a message to an RSU.

**8.2.2.1 MANAGE SNMP API - Web Based View**

ODE Demo UI provides a section for RSU SNMP Query that can be used to
enter the IP and OID information and send it to RSU through a REST
endpoint.

![](images/figure4.png)

**8.2.2.2 MANAGE SNMP API -- REST Interface**

ODE provides a REST API interface to query the health of SNMP devices.
Refer to [ODE REST API](https://usdot-jpo-ode.github.io/) online
documentation (<https://usdot-jpo-ode.github.io>) for details.

<a name="traveler-information-message-tim-interface">

#### 8.2.3 - Traveler Information Message (TIM) Interface

Refer to the
[ODESwagger.yaml](https://github.com/usdot-jpo-ode/jpo-ode/blob/develop/docs/ODESwagger.yaml)
for details of the TIM interface.

<a name="probe-data-management-messages-pdm-interface">

#### 8.2.4 - Probe Data Management Messages (PDM) Interface

Refer to the
[ODESwagger.yaml](https://github.com/usdot-jpo-ode/jpo-ode/blob/develop/docs/ODESwagger.yaml)
for details of the PDM interface.

<a name="ode-streaming-api">

### 8.3 - ODE Streaming API

ODE client applications will be able to subscribe to data streams via
two distinct but dependent interfaces.

1.  Clients may interface directly or through proxies with Kafka brokers
    to subscribe to a well-known topics. See section 7.3.1 for details.

2.  Clients may Interface directly with ODE through ODE provided
    WebSocket interface as defined by RFC 6455
    (<http://tools.ietf.org/html/rfc6455> ). See section 7.3.2 for
    details.

<a name="direct-kafka-interface">

#### 8.3.1 - Direct Kafka Interface

To interface with Kafka directly, the client needs to know the list of
available Kafka brokers and the name of the topic that will contain the
data. The client application may use any of the following methods to
access Kafka topics:

-   Native Kafka API (C, Java, Python, etc.)

-   Kafka API RESTful Proxy such as:
    <https://www.confluent.io/blog/a-comprehensive-open-source-rest-proxy-for-kafka/>

-   Kafka API WebSocket Proxy such as:
    <https://github.com/b/kafka-websocket/blob/master/pom.xml>

A sample Java client will be available in the ODE source repository
under jpo-ode-consumer-example project.

**Kafka Publish/Subscribe Topics**

For a complete list and description of ODE publish/subscribe topics,
refer to [ODE Output Schema Reference Document](#references). (Booz
Allen Hamilton 2018)

<a name="ode-output-schema-reference">

#### 8.3.2 - ODE Output Schema Reference

Full details of ODE streaming interface schemas are provided in the [ODE
Output Schema Reference Document](#references). (Booz Allen Hamilton
2018)

<a name="references">

# 9 - References

- Booz Allen Hamilton. 2018. "ODE Output Schema Reference."
- SAE International. 2016. 03 30. https://www.sae.org/standards/content/j2735_201603