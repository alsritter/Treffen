# Treffen

Treffen is an employee management system, which contains a role system and uses Redis as a database cache

## What can it do?

1. Login and Logout: authenticate the identity of the conference organizer, including the login and logout of the platform and the check-in client. After the authentication, relevant inquiry, change and other operations can be carried out, and participants can only query relevant conference information.

<br>

2. Pre-meeting management: the meeting organizer sets the initial information of the meeting, such as time, place, theme, etc.
At the same time, the conference organizer should add relevant participants to the meeting.
If the meeting information is changed, the meeting organizer can also make changes to it.

<br>

3. meeting notice: before the beginning of the meeting, the organizer should inform the relevant personnel to attend the meeting, and send the time, place, matters needing attention and other information to the participants by email.

<br>

4. the meeting management: in the process of the meeting, drawing the organization personnel can be signed in management, but also can timely check the attendance of the personnel.
Participants can sign in and register.

<br>

5. Feedback survey after the meeting: After the meeting is held, the meeting organizer will publish the feedback form on the website for participants to fill in.
The meeting organisers then extract the relevant statistics from the feedback forms submitted.

## Key Frameworks, Libraries and Runtimes

### Server side

* SpringBoot
* SpringSecurity
* Redis
* MyBatisPlus
* MySQL
* JWT
* Swagger2

### Front side

* Vue3.0
* Typescript
* Less
* Vue-Cli4
* Tinymce
* element-plus


## The role forms

Although the project can dynamically assign permissions to roles and create new roles, there are a few roles that are provided by default

| Role  | presentation                                                                                                                                           |
| ----- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Admin | Responsible for the maintenance and management of the entire system, management of user rights.The administrator owns all the functions of the system. |
| User  | User can use the functions of writing, viewing, downloading and deleting documents that have not passed the review.                                    |
| Check | In addition to the function of User, Check also has the ability to review documents.                                                                   |

## module

```
                                   ┌────────────────┐
      ┌───────────────────────────►│group management│
      │                            └────────────────┘
      │
      │                            ┌───────────────┐
      │ ┌─────────────────────────►│role management│
      │ │                          └───────────────┘
      │ │
┌─────┴─┴────────┐                 ┌────────────────────┐
│                ├────────────────►│authority management│
│     Treffen    │                 └────────────────────┘
│                │
└─────┬───┬────┬─┤                 ┌────────────────┐
      │   │    └─┴────────────────►│task management │
      │   │                        └────────────────┘
      │   │
      │   │                        ┌──────────────────┐
      │   └───────────────────────►│meeting management│
      │                            └──────────────────┘
      │
      │                            ┌──────────────────┐
      └───────────────────────────►│message management│
                                   └──────────────────┘
```

### group management
Organizational management is to manage the government and institutions involved in the system, including five modules: assigning personnel to the institutions, adding institutional information, editing institutional information, deleting institutional information and merging institutional information.If there are no people under the organization, the administrator can merge the organization. After merging, the original organization records in the database are not physically deleted, but simply changed to the merged state. The name of the original organization that published the document is not changed.


### meeting management
Meeting management is the management of meeting information and meeting flow process, including meeting creation, meeting review, meeting list view, meeting modification and document deletion

(1) Meeting creation: all users create meetings.

(2) Meeting audit: the auditor can audit the meeting, audit qualified meeting will be released, audit unqualified meeting will be rejected, the rejected meeting can be revised and submitted again, can also be deleted.

(3) View the meeting list: each user can view the meeting list to know the meeting sent out by himself, the meeting handled and the meeting that needs to be handled by himself.

(4) Meeting modification: Users who can view the meeting can choose to edit the meeting, and the system will record the download times of the meeting, as well as the modified user ID and IP address.

(5) Deletion of official documents: only the rejected meetings can be deleted. After the meeting is deleted, the status of the meeting is only modified to be deleted for later checking. That is to say, as long as the saved meetings are left in the database.(This is just logical deletion)


## display interface


*login page:*

![](https://images.alsritter.icu/images/2021/04/06/20210406123927.png)

*View the meeting content:*

![](https://images.alsritter.icu/images/2021/04/06/20210406124036.png)

*View the history of the meeting:*

![](https://images.alsritter.icu/images/2021/04/06/20210406124141.png)

As the sponsor of the meeting, you can set the following contents, including the meeting topic, the meeting starting and ending time, the departments to attend, the meeting place and the meeting content.After successful setting, the administrator user can modify the meeting information

![](https://images.alsritter.icu/images/2021/04/06/20210406124309.png)


Participants can view the content of the current meeting in the page

![](https://images.alsritter.icu/images/2021/04/06/20210406124402.png)

## Api Document 

click [here](https://github.com/alsritter/Treffen/blob/master/Document/READEME.md)
