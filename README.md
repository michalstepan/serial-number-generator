# Example of generating complex sequences

This example is demostrating possibilities of generating your own sequences. In JPA, you have only three possibilities how to achieve generated id:
- identity
- sequence
- table sequence

This attitude shows you an alternative to generate your own complex sequences (which are not doable in standard JPA) in thread-safe/transaction-safe way. Please visit blog www.michalstepan.com for more details.