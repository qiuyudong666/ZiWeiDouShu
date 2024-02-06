import service from "@/request/index";

// 登录接口
export function test() {//接口ILoginData接口的变量名
    return service({
        url: "/api/test",
        method: "GET"
    })
}
