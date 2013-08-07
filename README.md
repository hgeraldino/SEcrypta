SEcrypta
========

Provides the secure storage and retrieval of sensitive data. Uses a multi-layered combination of industry standard encryption algorithms to securely store and access sensitive information. 


Features:
-------------

 * Supports the storage and retrieval of different types of objects (Website Credentials, Credit Card, SSH credentials, SSL Certificates, etc.). 
 * Has an extensible object type model - adding new object types is very simple.
 * Provides access control at user and group levels.
 * Keeps audit trails of all user actions.
 * Can generate alerts of notable events, which can be sent to different types of destinations.

Cryptography:
-------------------
Uses a combination of symmetrical and asymmetrical encryption (hybrid) to encrypt sensitive data.

  * Symmetric keys are generated using AES 256bits
  * Asymmetric keys are generated using RSA 2048 bits
  * User private keys are encrypted using PBE 

Dependencies:
---------------------

