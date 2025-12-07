# Intoduction To Spring
As in our previous chapters we saw how actually java came in existance and capture the software development market .

But The main revolution actually came from the Introduction of Spring.

### Spring is a framework which having large no. of dependencies and in build libraries as developer can use them to build a software with minimum no. of efforts.

thus **Spring** provides

- Lightwieght Core
- Loose Coupling
- Ioc (Inversion Of Control)
- DI (Dependency Injection)
- Spring Container etc....

> let cover in depth **The Magical Concepts**

## INVERSION OF CONTROL
as name suggest Inversion of Control - *Control* means transfer of Control .... 

Transfer From the hand of Developer to Framework . as now developer does not have to take care of things , Spring will do . 

as an Example let say -

a developer want to make a tea - than what he will do - go to kitchen , take a vessel , pour milk , put on stove , add some tea leafs and so on ...

but What actually Spring revolutionize their - from now onwards there is no need to do all the things to developer . developer have to just say to spring please
brings some sort of cup of tea to me , and  that's what - spring will do all and gave a cup of tea to the developer .

This is inversion of Control .

means whenever developer need any Object , library , dependency Whatever Spring will provide it in some sort lines of Code . developer does not have to put much
efforts as he did before in previous techs ....

in normal World -
```
UserService obj = new UserService();
```
this is making object of UserService .

this considered as bad programming as having - tight Coupling , no controled lifecycle and testing is hard.

than what solution Spring provide here - developer does not need to do this now . he have to declare it a bean and Spring will handles things and make object of it.

> thus developer can more think of logic rather than of code .
---
## DEPENDENCY INJECTION
it is a mechanism of IOC . this is who actually behind IOC . what it do - as whatever needed to developer , as the things have to care by spring so he just marks
them and notify to spring . than IOC made a bean of it and inject it into **Spring Container** and whenever developer needed than provide it . that is what actually
dependecy injection is....

---

## SPRING CONTAINER
It is a place where all the things actually kept and working . it is like a **Power House** of spring . it Stored beans and provide them whenever needed .

- makes Objects
- Inject Dependencies
- manage lifecycle
- handle configuration
- take cares of Aop , manage proxy and transactions

---

## ASPECTS OF PROGRAMMING
a developer does not have to code only or just to make logic . behind it as well he have many things to take care such as -

- Logging
- Security
- Transaction
- performance Monitoring

So, these all above 4 points considered as Aspects of Programming . The biggest advantage their is that programmer does not have to think of them Spring will
dealt with them . thus programmer more thinks on logic building.

---

## Benefits
- lightwieght
- pojo based
- configurable
- test friendly

> but still having problems -

## Problems
- manual configuration
- heavy xml
- slow deployment







