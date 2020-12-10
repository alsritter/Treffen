# Treffen API Documents


**简介**:Treffen API Documents


**HOST**:localhost:7758


**联系人**:alsritter


**Version**:v0.0.1


**接口路径**:/v2/api-docs?group=tempGroup01


[TOC]






# 会议相关请求


## 创建一个会议


**接口地址**:`/api/meeting/createMeeting`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "recordDesc": "",
  "recordType": "",
  "startTime": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|meeting|创建会议的参数|body|true|CreateMeetingRequest|CreateMeetingRequest|
|&emsp;&emsp;recordDesc|会议描述||false|string||
|&emsp;&emsp;recordType|会议类型不能为空||true|string||
|&emsp;&emsp;startTime|会议开始时间||true|string(date-time)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"message": ""
}
```


## 结束当前会议


**接口地址**:`/api/meeting/endMeeting/{meetingId}`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|meetingId|会议的编号|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"message": ""
}
```


## 取得已经完成的会议


**接口地址**:`/api/meeting/getAllHistoryMeeting`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«List«Meeting»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|array|Meeting|
|&emsp;&emsp;deptLocation|创建该会议的人的部门位置|string||
|&emsp;&emsp;deptName|创建该会议的人的部门名称|string||
|&emsp;&emsp;email|创建该会议的人的邮箱地址|string||
|&emsp;&emsp;endTime|结束时间|string(date-time)||
|&emsp;&emsp;job|创建该会议的人的职位|string||
|&emsp;&emsp;meetingId|会议的 ID|integer(int32)||
|&emsp;&emsp;phone|创建该会议的人的手机号|string||
|&emsp;&emsp;recordDesc|会议的内容|string||
|&emsp;&emsp;recordType|会议的类型|string||
|&emsp;&emsp;startTime|开始时间|string(date-time)||
|&emsp;&emsp;userEId|创建该会议的人的工号|string||
|&emsp;&emsp;userName|创建该会议的人|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"deptLocation": "",
			"deptName": "",
			"email": "",
			"endTime": "",
			"job": "",
			"meetingId": 0,
			"phone": "",
			"recordDesc": "",
			"recordType": "",
			"startTime": "",
			"userEId": "",
			"userName": ""
		}
	],
	"message": ""
}
```


## 取得当前还未完成的会议


**接口地址**:`/api/meeting/getAllStartMeeting`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«List«Meeting»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|array|Meeting|
|&emsp;&emsp;deptLocation|创建该会议的人的部门位置|string||
|&emsp;&emsp;deptName|创建该会议的人的部门名称|string||
|&emsp;&emsp;email|创建该会议的人的邮箱地址|string||
|&emsp;&emsp;endTime|结束时间|string(date-time)||
|&emsp;&emsp;job|创建该会议的人的职位|string||
|&emsp;&emsp;meetingId|会议的 ID|integer(int32)||
|&emsp;&emsp;phone|创建该会议的人的手机号|string||
|&emsp;&emsp;recordDesc|会议的内容|string||
|&emsp;&emsp;recordType|会议的类型|string||
|&emsp;&emsp;startTime|开始时间|string(date-time)||
|&emsp;&emsp;userEId|创建该会议的人的工号|string||
|&emsp;&emsp;userName|创建该会议的人|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"deptLocation": "",
			"deptName": "",
			"email": "",
			"endTime": "",
			"job": "",
			"meetingId": 0,
			"phone": "",
			"recordDesc": "",
			"recordType": "",
			"startTime": "",
			"userEId": "",
			"userName": ""
		}
	],
	"message": ""
}
```


## 取得一个会议


**接口地址**:`/api/meeting/getMeeting/{meetingId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|meetingId|会议的编号|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«Meeting»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|Meeting|Meeting|
|&emsp;&emsp;deptLocation|创建该会议的人的部门位置|string||
|&emsp;&emsp;deptName|创建该会议的人的部门名称|string||
|&emsp;&emsp;email|创建该会议的人的邮箱地址|string||
|&emsp;&emsp;endTime|结束时间|string(date-time)||
|&emsp;&emsp;job|创建该会议的人的职位|string||
|&emsp;&emsp;meetingId|会议的 ID|integer(int32)||
|&emsp;&emsp;phone|创建该会议的人的手机号|string||
|&emsp;&emsp;recordDesc|会议的内容|string||
|&emsp;&emsp;recordType|会议的类型|string||
|&emsp;&emsp;startTime|开始时间|string(date-time)||
|&emsp;&emsp;userEId|创建该会议的人的工号|string||
|&emsp;&emsp;userName|创建该会议的人|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"deptLocation": "",
		"deptName": "",
		"email": "",
		"endTime": "",
		"job": "",
		"meetingId": 0,
		"phone": "",
		"recordDesc": "",
		"recordType": "",
		"startTime": "",
		"userEId": "",
		"userName": ""
	},
	"message": ""
}
```


## 修改会议的内容


**接口地址**:`/api/meeting/updateMeeting/{meetingId}`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "recordDesc": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|meetingId|会议的编号|path|true|integer(int32)||
|recordDesc|会议的内容|body|true|UpdateMeetingRequest|UpdateMeetingRequest|
|&emsp;&emsp;recordDesc|会议描述||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"message": ""
}
```


# 常用的工具接口


## 根据权限动态返回一个菜单


**接口地址**:`/api/utils/getMenu`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«List«Menu»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|array|Menu|
|&emsp;&emsp;itemList|该分组下的 item|array|TbMenuItem|
|&emsp;&emsp;&emsp;&emsp;isDeleted||string||
|&emsp;&emsp;&emsp;&emsp;itemDesc||string||
|&emsp;&emsp;&emsp;&emsp;itemGroup||integer||
|&emsp;&emsp;&emsp;&emsp;itemId||integer||
|&emsp;&emsp;&emsp;&emsp;itemName||string||
|&emsp;&emsp;&emsp;&emsp;itemPath||string||
|&emsp;&emsp;menuItemGroup|分组信息|TbMenuItemGroup|TbMenuItemGroup|
|&emsp;&emsp;&emsp;&emsp;groupIcon||string||
|&emsp;&emsp;&emsp;&emsp;groupId||integer||
|&emsp;&emsp;&emsp;&emsp;groupName||string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"itemList": [
				{
					"isDeleted": "",
					"itemDesc": "",
					"itemGroup": 0,
					"itemId": 0,
					"itemName": "",
					"itemPath": ""
				}
			],
			"menuItemGroup": {
				"groupIcon": "",
				"groupId": 0,
				"groupName": ""
			}
		}
	],
	"message": ""
}
```


## 生成验证码图片


**接口地址**:`/api/utils/imagecode`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>返回一张图片</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|uuid|生成验证码的唯一标识符|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||
|default|返回一张验证码图片，这个接口无需权限||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# 测试 API


## 说你好，需要 ADMIN 权限


**接口地址**:`/api/temp/hello`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«List«GrantedAuthority»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|array|GrantedAuthority|
|&emsp;&emsp;authority||string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"authority": ""
		}
	],
	"message": ""
}
```


# 认证


## 登录


**接口地址**:`/api/auth/login`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "password": "",
  "rememberMe": true,
  "username": "",
  "uuid": "",
  "verify": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|loginRequest|登陆的参数|body|true|LoginRequest|LoginRequest|
|&emsp;&emsp;password|密码||true|string||
|&emsp;&emsp;rememberMe|记住我的选项||true|boolean||
|&emsp;&emsp;username|登录名||true|string||
|&emsp;&emsp;uuid|唯一标识码||true|string||
|&emsp;&emsp;verify|验证码||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"message": ""
}
```


## 退出登陆


**接口地址**:`/api/auth/logout`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Result«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|返回码|integer(int32)|integer(int32)|
|data|返回数据|string||
|message|返回信息|string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"message": ""
}
```