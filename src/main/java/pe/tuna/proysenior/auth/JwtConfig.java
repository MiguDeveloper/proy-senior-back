package pe.tuna.proysenior.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEoAIBAAKCAQEA4LxCIyhdcRdOsgD8xvx9kAED7Os20Vnz3RZYWWxnVBZOLceV\n" +
            "OiGkKF8EY+cNRrZb3r67vUFILM87xlr1nSIhU6zYlP8lqtnqvLpyUzhVyx8xNVFf\n" +
            "x6uNkgjdxEQHzFVGpp9ZB/mpAHOYhcJ6RffkDiHwUsbVKtm52pY/hU86D1adkIFS\n" +
            "t7ZkPRVcwuADag9ihTe/Jvl/PET0UZJLpbuHAgP4SnWbf7AK785J5B0AmxJgZQoJ\n" +
            "WCrYYikbfqIdcopGWszPZPhb8RBUtEUiVNhsuFytSO1oQnPOBSKERW7Rb+bfOKSb\n" +
            "0ZNliLFjAbOzIkH4iIdg6c3DeqW1gO0AyHeduQIDAQABAoH/Vge7SboqCyDg/0Nh\n" +
            "gMsnRfkdh5SDZ6EHuZrUN2dIJuhjBSNh/N7j+JBnHddVPbyRbrOVKt3Sw1SRjV1E\n" +
            "qOJn36BLSL5jrQO+2ICHQ1RNg3RtYfvErqr9hund+0QPuCjs4twdOPBZwdJ+kLXi\n" +
            "GObMZpyXYxi6gazXeNYLevzZPQUze63ocpWXVCv3VOUerAhnZZvTQCa2BF3kaLxd\n" +
            "TYogsi/2JtCaRjA/lwFhOon0//jVyRlG9gaqysz2PU/Xsm4lL09+RFxJO1CyGNgW\n" +
            "2F+fTFN5UyPHjvz1EEYee1y9ZGkjWdHu5dZV5F51iGsYRzc8qSnk03gZOdWLxtHJ\n" +
            "Zw4BAoGBAPp59dMaU23lKf86UlI/lU+ahtuE3cg1QbIuGammDjCNOP5Fk13nwNpg\n" +
            "76FNKw/mXtwd/bH/LOwnji8V3Q0Z1/PtA8KxqEUOatVx4OdlB8WD96QXqnGIV982\n" +
            "7FRohvXyMbr9GQZvW0N+x1ZrhDEW7WAABivR3UDTmvxwNd7GcjMZAoGBAOWw+s2m\n" +
            "jKgz96f5PiU8XSQUdDo0dKGwmwFq+TloauggYMTjgjq/qef+iIihm0BHLBxryt8H\n" +
            "OF0HwCMpXFwUEMZfiJWkBYBwv88peKQ8+TpZGeBPAWKd+z0JsHxBhqAM/OYpXm7v\n" +
            "4VHEJ9NfpggPvlopatxN2TJ4MoCc0mVYo7OhAoGAGeWyPPlj1uDyzqjBCi/4yBo6\n" +
            "B0hdhe27tSh/DsNUhECVu/SFoBfuIKYVIKBR63ruI+QV7ulrQ59zW/ruuAQMB/Rh\n" +
            "hyfHNhyffyIfFs2jWBCk8hpgTQzDyRhspu2HxrYb3jF8/OVWkkvxYEYNjOXJ9TsL\n" +
            "aExyi9lVFPSlHTt3Y0ECgYAb/+AC87uPwY3+DvcRaPNds5Sbh8tz7mhm2th4tA7c\n" +
            "Lx48whMdAEJBApk4NqMLSeHJsSYw29t2E7zLTH5yxwtoczreKvl0t8naAg8vzjL/\n" +
            "dt8dpePgVqvKvASkkQRNPGgT0pUtZtaLtiK4tJ8zul+U9BmPs3m3mkllvjgznIOQ\n" +
            "IQKBgHZXr3JaSJzwhpqXFLxi1MknCwvgN8T9Yc+zUsAAolrgYNKzF0KrUdqqZLeE\n" +
            "CslKJTitcXqf8FtflUVNBDdyd9s5WNnRogdaHOw5agc3lOtPIy7bY9hjoUQs5Pu6\n" +
            "UsKH1VhMP4LcEwV19JxGgaSDrupWNiJ1VKQk40wxIR0ISsez\n" +
            "-----END RSA PRIVATE KEY-----";
    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4LxCIyhdcRdOsgD8xvx9\n" +
            "kAED7Os20Vnz3RZYWWxnVBZOLceVOiGkKF8EY+cNRrZb3r67vUFILM87xlr1nSIh\n" +
            "U6zYlP8lqtnqvLpyUzhVyx8xNVFfx6uNkgjdxEQHzFVGpp9ZB/mpAHOYhcJ6Rffk\n" +
            "DiHwUsbVKtm52pY/hU86D1adkIFSt7ZkPRVcwuADag9ihTe/Jvl/PET0UZJLpbuH\n" +
            "AgP4SnWbf7AK785J5B0AmxJgZQoJWCrYYikbfqIdcopGWszPZPhb8RBUtEUiVNhs\n" +
            "uFytSO1oQnPOBSKERW7Rb+bfOKSb0ZNliLFjAbOzIkH4iIdg6c3DeqW1gO0AyHed\n" +
            "uQIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
